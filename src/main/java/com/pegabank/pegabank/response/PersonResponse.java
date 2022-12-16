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
            PersonResponse person = new PersonResponse();
            person.setName(persons.get(i).getName());
            person.setEmail(persons.get(i).getEmail());
            person.setRole(persons.get(i).getRole());
            personResponses.add(person);
        }
        return personResponses;
    }
}
