package com.pegabank.pegabank.service;

import com.pegabank.pegabank.model.Person;

import java.util.List;


public interface PersonService {

    String save(Person person);

    Person getPerson(int id);

    String deletePerson(int id);

    List<Person> getAllPerson();
}
