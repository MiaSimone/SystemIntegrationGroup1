package com.example.demo.rest.controller;
/*
 * Maturity Level 2: Share operations across resources
 * Add model attributes validation and exception handling
 */
import com.example.demo.rest.exceptions.ResourceNotFoundException;
import com.example.demo.rest.exceptions.StudentNotFoundException;
import com.example.demo.rest.service.Student;
import com.example.demo.rest.model.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService repo;
    private Object Student;

//    private static final String conStr = "jdbc:mysql://localhost:3306/si-assignment4?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//    private static final String user = "root";
//    private static final String pass = "Cristine535";
//
//    DBConnection storage = new DBConnection(conStr, user, pass);
    @GetMapping("/")
    public List<Student> retrieveAllStudents() {
        return (List<Student>) repo.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<Student> retrieveStudent(@PathVariable long id)
    {
        Optional<Student> student = repo.findById((int) id);
        if (!student.isPresent())
            throw new StudentNotFoundException("id: " + id);

        EntityModel<Student> resource = EntityModel.of(student.get()); 								// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents()); // get link
        resource.add(linkTo.withRel("all-students"));																	// append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveStudent(id)).withSelfRel();      //add also link to self
        resource.add(selfLink);
        return resource;
    }

    @GetMapping("/{name}")
    public Student findByName(@PathVariable(name = "name") String name) throws ResourceNotFoundException {
        return repo.findByName(name);
    }

    @PostMapping("/")
    public ResponseEntity<Object> saveStudent(@Valid @RequestBody Student student)
    {
        Student savedStudent = repo.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();
//        return " record saved..";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        repo.deleteById(id);
        return " record deleted...";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@Valid @RequestBody Student student, @PathVariable(value = "id") int id) throws ResourceNotFoundException {
        Optional<Student> found = repo.findById(id);

        if (!found.isPresent())
            return ResponseEntity.badRequest()
                    .header("Custom-Header", "foo")
                    .body("Try again")
                    .notFound().build();
        student.setId(Long.valueOf(id));
        repo.save(student);
        return ResponseEntity.ok()
                .header("Custom-Header", "foo")
                .body("Notice the custom header")
                .noContent().build();
    }
}
