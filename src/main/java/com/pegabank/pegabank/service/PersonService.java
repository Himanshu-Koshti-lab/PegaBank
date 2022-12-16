package com.pegabank.pegabank.service;

import com.pegabank.pegabank.model.Person;
import com.pegabank.pegabank.response.PersonResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface PersonService {

    ResponseEntity<String> save(Person person);

    PersonResponse getPerson(int id);

    String deletePerson(int id);

    List<PersonResponse> getAllPerson();
}
