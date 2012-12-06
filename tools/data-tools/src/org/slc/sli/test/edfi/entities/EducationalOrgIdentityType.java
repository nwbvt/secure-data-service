//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.06 at 10:00:50 AM EST 
//


package org.slc.sli.test.edfi.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Encapsulates the possible attributes that can be used to lookup the identity of educational organizations, especially ESCs, LEAs (districts), and schools.
 * 
 * <p>Java class for EducationalOrgIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EducationalOrgIdentityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="StateOrganizationId" type="{http://ed-fi.org/0100}IdentificationCode"/>
 *         &lt;element name="EducationOrgIdentificationCode" type="{http://ed-fi.org/0100}EducationOrgIdentificationCode" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EducationalOrgIdentityType", propOrder = {
    "stateOrganizationId",
    "educationOrgIdentificationCode"
})
public class EducationalOrgIdentityType {

    @XmlElement(name = "StateOrganizationId")
    protected String stateOrganizationId;
    @XmlElement(name = "EducationOrgIdentificationCode")
    protected List<EducationOrgIdentificationCode> educationOrgIdentificationCode;

    /**
     * Gets the value of the stateOrganizationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStateOrganizationId() {
        return stateOrganizationId;
    }

    /**
     * Sets the value of the stateOrganizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStateOrganizationId(String value) {
        this.stateOrganizationId = value;
    }

    /**
     * Gets the value of the educationOrgIdentificationCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the educationOrgIdentificationCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEducationOrgIdentificationCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EducationOrgIdentificationCode }
     * 
     * 
     */
    public List<EducationOrgIdentificationCode> getEducationOrgIdentificationCode() {
        if (educationOrgIdentificationCode == null) {
            educationOrgIdentificationCode = new ArrayList<EducationOrgIdentificationCode>();
        }
        return this.educationOrgIdentificationCode;
    }

}
