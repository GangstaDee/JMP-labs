package com.jmp.soap.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.Random;

@WebService
public class RandomNumberGenerator {

    @WebMethod
    @WebResult(name = "random")
    public int randomNumber(
            @WebParam(name = "lowerBound") int lowerBound,
            @WebParam(name = "upperBound") int upperBound) {

        return new Random().nextInt((upperBound - lowerBound) + 1) + lowerBound;
    }

}
