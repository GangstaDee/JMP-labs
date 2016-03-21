
package com.jmp.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for randomNumberResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="randomNumberResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="random" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "randomNumberResponse", namespace = "http://client.soap.jmp.com/", propOrder = {
    "random"
})
public class RandomNumberResponse {

    protected int random;

    /**
     * Gets the value of the random property.
     * 
     */
    public int getRandom() {
        return random;
    }

    /**
     * Sets the value of the random property.
     * 
     */
    public void setRandom(int value) {
        this.random = value;
    }

}
