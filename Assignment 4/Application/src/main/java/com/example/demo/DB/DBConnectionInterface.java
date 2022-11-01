package com.example.demo.DB;

import com.example.demo.grpc2.domain.entity.Book;
import com.example.demo.rest.model.Student;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public interface DBConnectionInterface {

//    STUDENTS
    public Student getStudentWithId(long studentId) throws SQLException;
    public List<Student> getStudents() throws SQLException;
    public int createStudent(Student student) throws SQLException;

//    BOOKS
    public Book getBookWithId(long bookId) throws SQLException;

//    FILL DB
    public void fillDB() throws ClassNotFoundException, FileNotFoundException, SQLException;

}
