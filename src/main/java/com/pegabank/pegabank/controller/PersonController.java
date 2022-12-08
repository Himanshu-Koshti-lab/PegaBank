package com.pegabank.pegabank.controller;

import com.pegabank.pegabank.model.Person;
import com.pegabank.pegabank.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }
}
