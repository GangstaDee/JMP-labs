
package com.jmp.soap.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RandomNumberGenerator", targetNamespace = "http://server.soap.jmp.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RandomNumberGenerator {


    /**
     * 
     * @param upperBound
     * @param lowerBound
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(name = "random", targetNamespace = "")
    @RequestWrapper(localName = "randomNumber", targetNamespace = "http://server.soap.jmp.com/", className = "com.jmp.soap.server.RandomNumber")
    @ResponseWrapper(localName = "randomNumberResponse", targetNamespace = "http://server.soap.jmp.com/", className = "com.jmp.soap.server.RandomNumberResponse")
    @Action(input = "http://server.soap.jmp.com/RandomNumberGenerator/randomNumberRequest", output = "http://server.soap.jmp.com/RandomNumberGenerator/randomNumberResponse")
    public int randomNumber(
        @WebParam(name = "lowerBound", targetNamespace = "")
        int lowerBound,
        @WebParam(name = "upperBound", targetNamespace = "")
        int upperBound);

}
