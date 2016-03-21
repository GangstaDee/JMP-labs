package com.jmp.soap.main;

import com.jmp.soap.client.RandomNumberGenerator;
import com.jmp.soap.client.RandomNumberGeneratorService;

/**
 * Created on 3/21/2016.
 */
public class Runner {

    public static void main(String[] args) {

        try {

            RandomNumberGeneratorService service = new RandomNumberGeneratorService();
            RandomNumberGenerator port = service.getRandomNumberGeneratorPort();

            for(int i = 0; i < 6; i++) {
                int response = port.randomNumber(1,49);
                System.out.println("Random number: " + response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
