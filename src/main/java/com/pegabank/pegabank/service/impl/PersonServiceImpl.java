package com.pegabank.pegabank.service.impl;

import com.pegabank.pegabank.model.Person;
import com.pegabank.pegabank.repository.PersonRepository;
import com.pegabank.pegabank.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
