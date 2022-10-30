package com.example.demo.grpc2.dao;

import com.example.demo.grpc2.domain.entity.Book;
import com.example.demo.rest.service.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.NoSuchElementException;

public class StudentDAO {

    public static Student findById(String id)
    {
        // We use entity managers to search in the database
        // The persistenceUnitName will  be reffered in the persistence.xml file in META-INF folder
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("si-assignment4");
        EntityManager em = emf.createEntityManager();

        // We search database for a record with the given  id using the predefined find() method

        Student result = em.find(Student.class, Long.valueOf(id));

        // If there is no record found with the provided student id, then we throw a NoSuchElement exception.
        if(result == null)
        {
            throw new NoSuchElementException("NO DATA FOUND WITH THE ID "+ id);
        }

        // If record has been found,, return the result.
        return result;
    }
}
