package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class PersonDAO {
    //fields
    private EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //add functions
    public Person getDataId(int id ){
        return entityManager.find(Person.class, id);
    }
    public Person getDataByEmail(String email) {
        // Create a TypedQuery to retrieve a Person by their email
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.email = :email", Person.class);
        query.setParameter("email", email);

        // Execute the query and get the single result (or null if not found)
        return query.getSingleResult();
    }
    
    @Transactional
    public void addPerson(Person person) {
        entityManager.persist(person);
    }
}
