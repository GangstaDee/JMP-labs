package com.jmp.person.main;

import com.jmp.person.entity.Person;
import com.jmp.person.entity.PersonStorage;
import com.jmp.person.exception.PersonNotFoundException;
import com.jmp.person.facade.PersonKeeper;
import com.jmp.person.file.FileWriter;

/**
 * Created on 13.12.2015.
 */
public class Runner {

    public static void main(String[] args) {

        PersonStorage storage = new PersonStorage();
        storage.addPerson(1, new Person("Nella",23,150));
        storage.addPerson(2, new Person("Maryia",24,180));
        storage.addPerson(3, new Person("Peter",21,145));

        FileWriter writer = new FileWriter("persons.txt");
        writer.save(storage);

        PersonKeeper keeper = new PersonKeeper(storage, writer);
        try {
            System.out.println(keeper.getSmartestPerson(1, 2));
            keeper.updatePersonIQ(1, 10);
            System.out.println(keeper.getSmartestPerson(1, 2));
            keeper.updatePersonIQ(2, 20);
            keeper.moveSomeIQ(2, 3, 15);
        } catch(PersonNotFoundException ex) {
            System.err.println();
        }

    }
}
