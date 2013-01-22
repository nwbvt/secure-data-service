//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 04:15:23 PM EST 
//


package org.ed_fi._0100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import com.sun.xml.bind.Locatable;
import com.sun.xml.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


/**
 * The numbers, letters, and symbols used to identify an electronic mail (e-mail) user within the network to which the individual or organization belongs.
 * 
 * <p>Java class for ElectronicMail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElectronicMail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmailAddress" type="{http://ed-fi.org/0100}ElectronicMailAddress"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EmailAddressType" type="{http://ed-fi.org/0100}ElectronicMailAddressType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectronicMail", propOrder = {
    "emailAddress"
})
public class ElectronicMail
    implements Locatable
{

    @XmlElement(name = "EmailAddress", required = true)
    protected String emailAddress;
    @XmlAttribute(name = "EmailAddressType")
    protected ElectronicMailAddressType emailAddressType;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the emailAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets the value of the emailAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Gets the value of the emailAddressType property.
     * 
     * @return
     *     possible object is
     *     {@link ElectronicMailAddressType }
     *     
     */
    public ElectronicMailAddressType getEmailAddressType() {
        return emailAddressType;
    }

    /**
     * Sets the value of the emailAddressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicMailAddressType }
     *     
     */
    public void setEmailAddressType(ElectronicMailAddressType value) {
        this.emailAddressType = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
