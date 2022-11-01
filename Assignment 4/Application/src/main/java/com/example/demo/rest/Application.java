package com.example.demo.rest;

import com.example.demo.DB.DBConnection;
import com.example.demo.grpc2.domain.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.sql.SQLException;

@SpringBootApplication
public class Application {

	private static final String conStr = "jdbc:mysql://localhost:3306/si-assignment4?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String user = "root";
	private static final String pass = "Cristine535";
	public static void main(String[] args) throws SQLException, FileNotFoundException, ClassNotFoundException {
		DBConnection storage = new DBConnection(conStr, user, pass);
		storage.fillDB();
		SpringApplication.run(Application.class, args);
	}

}
