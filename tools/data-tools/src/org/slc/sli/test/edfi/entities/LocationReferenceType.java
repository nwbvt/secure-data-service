//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.06 at 10:00:50 AM EST 
//


package org.slc.sli.test.edfi.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Provides alternative references for location during interchange. Use XML IDREF to reference a location record that is included in the interchange
 * 
 * <p>Java class for LocationReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LocationReferenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ReferenceType">
 *       &lt;sequence>
 *         &lt;element name="LocationIdentity" type="{http://ed-fi.org/0100}LocationIdentityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LocationReferenceType", propOrder = {
    "locationIdentity"
})
public class LocationReferenceType
    extends ReferenceType
{

    @XmlElement(name = "LocationIdentity")
    protected LocationIdentityType locationIdentity;

    /**
     * Gets the value of the locationIdentity property.
     * 
     * @return
     *     possible object is
     *     {@link LocationIdentityType }
     *     
     */
    public LocationIdentityType getLocationIdentity() {
        return locationIdentity;
    }

    /**
     * Sets the value of the locationIdentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationIdentityType }
     *     
     */
    public void setLocationIdentity(LocationIdentityType value) {
        this.locationIdentity = value;
    }

}
