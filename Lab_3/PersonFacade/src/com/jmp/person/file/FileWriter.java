package com.jmp.person.file;

import com.jmp.person.entity.Person;
import com.jmp.person.entity.PersonStorage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created on 13.12.2015.
 */
public class FileWriter {

    private String fileName;

    public FileWriter(String fileName) {
        this.fileName = fileName;
    }

    public void save(PersonStorage storage) {

        try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")){
            for (Person person : storage.getPersons()) {
                writer.println(person.toString());
            }
        } catch (FileNotFoundException| UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }
}
