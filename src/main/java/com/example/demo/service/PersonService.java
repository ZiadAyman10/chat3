package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.entity.Person;

@Service
public class PersonService {
    //FILEDS
    private PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    public Person getPerson(int id){
        return personDAO.getDataId(id);
    }
    public Person getPerson(String email){
        return personDAO.getDataByEmail(email);
    }
}
