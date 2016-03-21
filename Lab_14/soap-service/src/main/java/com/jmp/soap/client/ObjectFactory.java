
package com.jmp.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jmp.soap.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RandomNumber_QNAME = new QName("http://server.soap.jmp.com/", "randomNumber");
    private final static QName _RandomNumberResponse_QNAME = new QName("http://server.soap.jmp.com/", "randomNumberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jmp.soap.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RandomNumberResponse }
     * 
     */
    public RandomNumberResponse createRandomNumberResponse() {
        return new RandomNumberResponse();
    }

    /**
     * Create an instance of {@link RandomNumber }
     * 
     */
    public RandomNumber createRandomNumber() {
        return new RandomNumber();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RandomNumber }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.jmp.com/", name = "randomNumber")
    public JAXBElement<RandomNumber> createRandomNumber(RandomNumber value) {
        return new JAXBElement<RandomNumber>(_RandomNumber_QNAME, RandomNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RandomNumberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.soap.jmp.com/", name = "randomNumberResponse")
    public JAXBElement<RandomNumberResponse> createRandomNumberResponse(RandomNumberResponse value) {
        return new JAXBElement<RandomNumberResponse>(_RandomNumberResponse_QNAME, RandomNumberResponse.class, null, value);
    }

}
