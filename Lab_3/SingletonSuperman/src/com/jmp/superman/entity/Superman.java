package com.jmp.superman.entity;

/**
 * Created by Dasha.Selyavko on 13.12.2015.
 */
public class Superman {

    private String firstName;
    private String lastName;

    private Superman() {
        System.out.println("New Superman was born!");
        firstName = "Clark";
        lastName = "Kent";
    }

    private static class SupermanHolder {

        static {
            System.out.println("Superman holder is loaded...");
        }

        private static final Superman instance = new Superman();
    }

    public static Superman getInstance() {

        System.out.println("Calling Superman...");
        return SupermanHolder.instance;
    }

    public void run() {
        System.out.println("Superman " + getFirstName() + " " + getLastName() + " is running!");
    }

    public void rescue() {
        System.out.println("Superman " + getFirstName() + " " + getLastName() + " is saving life!");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
