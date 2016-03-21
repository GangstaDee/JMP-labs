package com.jmp.soap.server.publisher;

import com.jmp.soap.server.RandomNumberGenerator;

import javax.xml.ws.Endpoint;

/**
 * Created on 3/20/2016.
 */
public class WebServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8085/ws/random", new RandomNumberGenerator());
        System.out.println("Service is published successfully");
    }
}
