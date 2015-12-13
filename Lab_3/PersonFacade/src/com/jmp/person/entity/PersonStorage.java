package com.jmp.person.entity;

import java.util.*;

/**
 * Created on 13.12.2015.
 */
public class PersonStorage {

    private Map<Integer, Person> persons = new HashMap<>();

    public void addPerson(int ID, Person person) {

        persons.put(ID, person);
    }

    public Person getPersonByID(int ID) {

        return persons.get(ID);
    }

    public List<Person> getPersons() {

        return Collections.unmodifiableList(new ArrayList<>(persons.values()));
    }
}