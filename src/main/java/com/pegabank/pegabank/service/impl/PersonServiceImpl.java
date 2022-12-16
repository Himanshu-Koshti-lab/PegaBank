package com.pegabank.pegabank.service.impl;

import com.pegabank.pegabank.model.Person;
import com.pegabank.pegabank.repository.PersonRepository;
import com.pegabank.pegabank.response.PersonResponse;
import com.pegabank.pegabank.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String save(Person person) {
        List<Person> existingPerson = personRepository.findByEmail(person.getEmail());
        if (existingPerson.isEmpty()) {
            person.setPassword(passwordEncoder.encode(person.getPassword()));
            personRepository.save(person);
            return "Saved";
        }
        return "Person with Email already Present : " + existingPerson.get(0).getEmail();
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
    public List<PersonResponse> getAllPerson() {
        List<Person> personList = personRepository.findAll();
        return PersonResponse.personResponses(personList);
    }
}
