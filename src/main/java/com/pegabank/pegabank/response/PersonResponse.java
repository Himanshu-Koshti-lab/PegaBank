package com.pegabank.pegabank.response;

import com.pegabank.pegabank.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponse {
    private String name;
    private String email;
    private String role;

    public static List<PersonResponse> personResponses(List<Person> persons) {
        List<PersonResponse> personResponses = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            personResponses.add(personResponse(persons.get(i)));
        }
        return personResponses;
    }

    public static PersonResponse personResponse(Person person) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setName(person.getName());
        personResponse.setEmail(person.getEmail());
        personResponse.setRole(person.getRole());
        return personResponse;
    }
}
