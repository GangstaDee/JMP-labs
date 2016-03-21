
package com.jmp.soap.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for randomNumber complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="randomNumber">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lowerBound" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="upperBound" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "randomNumber", namespace = "http://client.soap.jmp.com/", propOrder = {
    "lowerBound",
    "upperBound"
})
public class RandomNumber {

    protected int lowerBound;
    protected int upperBound;

    /**
     * Gets the value of the lowerBound property.
     * 
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * Sets the value of the lowerBound property.
     * 
     */
    public void setLowerBound(int value) {
        this.lowerBound = value;
    }

    /**
     * Gets the value of the upperBound property.
     * 
     */
    public int getUpperBound() {
        return upperBound;
    }

    /**
     * Sets the value of the upperBound property.
     * 
     */
    public void setUpperBound(int value) {
        this.upperBound = value;
    }

}
