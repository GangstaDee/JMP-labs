package com.jmp.person.facade;

import com.jmp.person.entity.Person;
import com.jmp.person.entity.PersonStorage;
import com.jmp.person.file.FileWriter;


/**
 * Created on 13.12.2015.
 */
public class PersonKeeper {

    private PersonStorage storage = new PersonStorage();  //can be loaded separately from some source
    private FileWriter writer;

    public PersonKeeper (FileWriter writer) {
        this.writer = writer;
    }

    public void addPerson(int id, Person p) {
        storage.addPerson(id, p);
        saveStorage();
    }

    public Person getSmartestPerson(int firstID, int secondID) {
        Person p1 = storage.getPersonByID(firstID);
        Person p2 = storage.getPersonByID(secondID);
        if(p1 == null && p2 == null) {
            System.err.println("No person exists with ID = " + ((p1 == null) ? firstID : secondID));
            return null;
        }
        return (p1.getIq() > p2.getIq()) ? p1 : (p1.getIq() < p2.getIq()) ? p2 : null;
    }

    public void updatePersonIQ(int personID, int delta) {

        Person p = storage.getPersonByID(personID);
        if(p == null) {
            System.err.println("No person exists with ID = " + personID);
            return;
        }
        p.setIq(p.getIq() + delta);
        saveStorage();
    }

    public void moveSomeIQ(int personToIncreaseID, int personToDecreaseID, int delta) {

        updatePersonIQ(personToIncreaseID, delta);
        updatePersonIQ(personToDecreaseID, -delta);
        saveStorage();
    }

    private void saveStorage() {
        writer.save(storage);
    }

}
