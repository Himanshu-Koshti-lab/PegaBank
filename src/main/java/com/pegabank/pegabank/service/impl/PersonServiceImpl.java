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
    public String save(Person person) {
        Person existingPerson = personRepository.findById(person.getId()).orElse(null);
        if (existingPerson == null) {
            personRepository.save(person).equals(person);
            return "Saved";
        }
        return "Person with Id already Present : " + person.getId();
    }

    @Override
    public Person getPerson(int id) {
        Person existingPerson = personRepository.findById(id).orElse(null);
        return existingPerson != null ? existingPerson : null;
    }

    @Override
    public String deletePerson(int id) {
        Person person = personRepository.findById(id).orElse(null);
        if (person != null) {
            personRepository.delete(person);
            return "Successfully deleted";
        } else {
            return "Person not found";
        }

    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
}
