package com.example.demo.DB;

import com.example.demo.grpc2.domain.entity.Book;
import com.example.demo.rest.model.Student;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection implements DBConnectionInterface{
    private String connectionString;
    private String username, password;

    public DBConnection(String conStr, String user, String pass){
        connectionString = conStr;
        username = user;
        password = pass;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionString, username, password);
    }


    @Override
    public Student getStudentWithId(long studentId) throws SQLException {
        var sql = "select id, name, mail, balance from Students where id = ?";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, studentId);

            try (var resultSet = stmt.executeQuery()) {
                if (resultSet.next()){
                    var id = resultSet.getLong("id");
                    var name = resultSet.getString("name");
                    var mail = resultSet.getString("mail");
                    var balance = resultSet.getInt("balance");
                    return new Student(id, name, mail, balance);
                }
                return null;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        try (var con = getConnection();
             var stmt = con.createStatement()) {
            var results = new ArrayList<Student>();

            try (ResultSet resultSet = stmt.executeQuery("select id, name, mail, balance from Students")) {

                while (resultSet.next()) {
                    var id = resultSet.getLong("id");
                    var name = resultSet.getString("name");
                    var mail = resultSet.getString("mail");
                    var balance = resultSet.getInt("balance");
                    Student s = new Student(id, name, mail, balance);
                    results.add(s);
                }
            }

            return results;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int createStudent(Student student) throws SQLException {
        var sql = "insert into Students(name, mail, balance) values (?, ?, ?)";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getMail());
            stmt.setInt(3, student.getBalance());
            stmt.executeUpdate();

            // get the newly created id
            try (var resultSet = stmt.getGeneratedKeys()) {
                resultSet.next();
                int newId = resultSet.getInt(1);
                return newId;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getBookWithId(long bookId) throws SQLException {
        var sql = "select id, title, price from Books where id = ?";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql)) {
            stmt.setLong(1, bookId);

            try (var resultSet = stmt.executeQuery()) {
                if (resultSet.next()){
                    var id = resultSet.getLong("id");
                    var title = resultSet.getString("title");
                    var price = resultSet.getInt("price");
                    return new Book((int) id, title, price);
                }
                return null;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void fillDB() throws ClassNotFoundException, FileNotFoundException, SQLException {
        String aSQLScriptFilePath = "Assignment 4/Application/src/main/resources/fill_db_script.sql";

        var con = getConnection();
        // Initialize object for ScripRunner
        ScriptRunner sr = new ScriptRunner(con);

        // Give the input file to Reader
        Reader reader = new BufferedReader(new FileReader(aSQLScriptFilePath));

        // Exctute script
        sr.runScript(reader);

    }
}
