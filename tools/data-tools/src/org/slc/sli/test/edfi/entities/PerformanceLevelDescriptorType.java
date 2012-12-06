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
 * Provides references for performance level descriptors during interchange. Use XML IDREF to reference a course record that is included in the interchange
 * 
 * <p>Java class for PerformanceLevelDescriptorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerformanceLevelDescriptorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ReferenceType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="CodeValue" type="{http://ed-fi.org/0100}CodeValue"/>
 *           &lt;element name="Description" type="{http://ed-fi.org/0100}Description"/>
 *         &lt;/choice>
 *         &lt;element name="PerformanceLevelMet" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerformanceLevelDescriptorType", propOrder = {
    "codeValue",
    "description",
    "performanceLevelMet"
})
public class PerformanceLevelDescriptorType
    extends ReferenceType
{

    @XmlElement(name = "CodeValue")
    protected String codeValue;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "PerformanceLevelMet")
    protected Boolean performanceLevelMet;

    /**
     * Gets the value of the codeValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * Sets the value of the codeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeValue(String value) {
        this.codeValue = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the performanceLevelMet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPerformanceLevelMet() {
        return performanceLevelMet;
    }

    /**
     * Sets the value of the performanceLevelMet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPerformanceLevelMet(Boolean value) {
        this.performanceLevelMet = value;
    }

}
