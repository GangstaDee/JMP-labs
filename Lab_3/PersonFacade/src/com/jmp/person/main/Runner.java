package com.jmp.person.main;

import com.jmp.person.entity.Person;
import com.jmp.person.facade.PersonKeeper;
import com.jmp.person.file.FileWriter;

/**
 * Created on 13.12.2015.
 */
public class Runner {

    public static void main(String[] args) {

        PersonKeeper keeper = new PersonKeeper(new FileWriter("persons.txt"));
        keeper.addPerson(1, new Person("Nella",23,150));
        keeper.addPerson(2, new Person("Maryia",24,180));
        keeper.addPerson(3, new Person("Peter",21,145));

        System.out.println(keeper.getSmartestPerson(1,2));
        keeper.updatePersonIQ(1,10);
        System.out.println(keeper.getSmartestPerson(1,2));
        keeper.updatePersonIQ(2,20);
        keeper.moveSomeIQ(2,3,15);

    }
}
