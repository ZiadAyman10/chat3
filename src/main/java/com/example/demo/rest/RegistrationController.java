package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dao.PersonDAO;
import com.example.demo.entity.Person;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    
    private PersonDAO personDAO;
    
    @Autowired
    public RegistrationController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Person person) {
        // Check if the email is already registered
        if (personDAO.getDataByEmail(person.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already registered");
        }
        
        // Add the new person
        personDAO.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful");
    }
}
