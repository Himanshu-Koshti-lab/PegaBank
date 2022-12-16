package com.pegabank.pegabank.controller;

import com.pegabank.pegabank.model.Person;
import com.pegabank.pegabank.response.PersonResponse;
import com.pegabank.pegabank.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonServiceImpl personService;

    @PostMapping("/register")
    public String registerPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return personService.getPerson(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable int id) {
        return personService.deletePerson(id);
    }

    @GetMapping("/getAllPerson")
    public List<PersonResponse> getAllPerson() {
        return personService.getAllPerson();
    }
}
