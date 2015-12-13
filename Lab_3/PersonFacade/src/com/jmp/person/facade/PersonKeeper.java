package com.jmp.person.facade;

import com.jmp.person.entity.Person;
import com.jmp.person.entity.PersonStorage;
import com.jmp.person.exception.PersonNotFoundException;
import com.jmp.person.file.FileWriter;


/**
 * Created on 13.12.2015.
 */
public class PersonKeeper {

    private PersonStorage storage;
    private FileWriter writer;

    public PersonKeeper (PersonStorage storage, FileWriter writer) {
        this.storage = storage;
        this.writer = writer;
    }

    public void addPerson(int id, Person p) {
        storage.addPerson(id, p);
        saveStorage();
    }

    public Person getSmartestPerson(int firstID, int secondID) throws PersonNotFoundException {
        Person p1 = storage.getPersonByID(firstID);
        Person p2 = storage.getPersonByID(secondID);
        if(p1 == null || p2 == null) {
            throw new PersonNotFoundException("No person exists with ID = " + ((p1 == null) ? firstID : secondID));
        }
        return (p1.getIq() > p2.getIq()) ? p1 : (p1.getIq() < p2.getIq()) ? p2 : null;
    }

    public void updatePersonIQ(int personID, int delta) throws PersonNotFoundException {

        Person p = storage.getPersonByID(personID);
        if(p == null) {
            throw new PersonNotFoundException("No person exists with ID = " + personID);
        }
        p.setIq(p.getIq() + delta);
        saveStorage();

    }

    public void moveSomeIQ(int personToIncreaseID, int personToDecreaseID, int delta) throws PersonNotFoundException {

        updatePersonIQ(personToIncreaseID, delta);
        updatePersonIQ(personToDecreaseID, -delta);
        saveStorage();
    }

    private void saveStorage() {
        writer.save(storage);
    }

}
