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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Changed to include BeginDate and an embedded EducationalOrgReference. Removed SchoolYear.
 * 
 * <p>Java class for SLC-GradingPeriodIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-GradingPeriodIdentityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EducationalOrgReference" type="{http://ed-fi.org/0100}SLC-EducationalOrgReferenceType"/>
 *         &lt;element name="GradingPeriod" type="{http://ed-fi.org/0100}GradingPeriodType"/>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-GradingPeriodIdentityType", propOrder = {
    "educationalOrgReference",
    "gradingPeriod",
    "beginDate"
})
public class SLCGradingPeriodIdentityType {

    @XmlElement(name = "EducationalOrgReference", required = true)
    protected SLCEducationalOrgReferenceType educationalOrgReference;
    @XmlElement(name = "GradingPeriod", required = true)
    protected GradingPeriodType gradingPeriod;
    @XmlElement(name = "BeginDate", required = true)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "date")
    protected String beginDate;

    /**
     * Gets the value of the educationalOrgReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public SLCEducationalOrgReferenceType getEducationalOrgReference() {
        return educationalOrgReference;
    }

    /**
     * Sets the value of the educationalOrgReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCEducationalOrgReferenceType }
     *     
     */
    public void setEducationalOrgReference(SLCEducationalOrgReferenceType value) {
        this.educationalOrgReference = value;
    }

    /**
     * Gets the value of the gradingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link GradingPeriodType }
     *     
     */
    public GradingPeriodType getGradingPeriod() {
        return gradingPeriod;
    }

    /**
     * Sets the value of the gradingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link GradingPeriodType }
     *     
     */
    public void setGradingPeriod(GradingPeriodType value) {
        this.gradingPeriod = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

}
