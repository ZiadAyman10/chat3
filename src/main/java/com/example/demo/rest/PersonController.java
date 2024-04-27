package com.example.demo.rest;

import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ChatMessage;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable("personId") int personId) {
        return personService.getPerson(personId);
    }
    @GetMapping("/api/person/email/{email}")
    public Person getPerson(@PathVariable("email") String email) {
        return personService.getPerson(email);
    }
}
