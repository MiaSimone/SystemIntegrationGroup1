package com.example.demo.grpc2.dao;

import com.example.demo.DB.DBConnection;
import com.example.demo.grpc2.domain.entity.Book;
import com.example.demo.rest.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class BookDAO {

    private static final String conStr = "jdbc:mysql://localhost:3306/si-assignment4?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String pass = "Cristine535";
    public static Book findById(String id) throws SQLException {
        // We use entity managers to search in the database
        // The persistenceUnitName will  be reffered in the persistence.xml file in META-INF folder
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("si-assignment4");
//        EntityManager em = emf.createEntityManager();
//
//        // We search database for a record with the given  id using the predefined find() method
//
//        Book result = em.find(Book.class, Integer.valueOf(id));

        DBConnection storage = new DBConnection(conStr, user, pass);
        Book result = storage.getBookWithId(Long.valueOf(id));

        // If there is no record found with the provided student id, then we throw a NoSuchElement exception.
        if(result == null)
        {
            throw new NoSuchElementException("NO DATA FOUND WITH THE ID "+ id);
        }

        // If record has been found,, return the result.
        return result;
    }
}
