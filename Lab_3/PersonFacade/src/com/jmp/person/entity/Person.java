package com.jmp.person.entity;

public class Person {

    private String name;
    private int age;
    private int iq;

    public Person(String name, int age, int iq) {

        this.name = name;
        this.age = age;
        this.iq = iq;
    }

    public int getIq() {

        return iq;
    }

    public void setIq(int iq) {

        this.iq = iq;
    }

    @Override
    public String toString() {

        return "Person {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", iq = " + iq +
                '}';
    }
}
