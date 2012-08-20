//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.17 at 02:49:01 PM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This entity is a plan outlining the required
 * 				credits, credits by
 * 				subject, credits by course, and other criteria
 * 				required for graduation. A
 * 				graduation
 * 				plan may be one or more standard
 * 				plans defined by an education
 * 				organization and/or
 * 				individual plans for
 * 				some or all students.
 * 			
 * 
 * <p>Java class for graduationPlan complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="graduationPlan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="graduationPlanType">
 *           &lt;simpleType>
 *             &lt;restriction base="{}graduationPlanType">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="individualPlan" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="totalCreditsRequired" type="{}credits"/>
 *         &lt;element name="creditsBySubject" type="{}creditsBySubject" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="creditsByCourse" type="{}creditsByCourse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "graduationPlan", propOrder = {
    "graduationPlanType",
    "individualPlan",
    "totalCreditsRequired",
    "creditsBySubject",
    "creditsByCourse"
})
public class GraduationPlan {

    @XmlElement(required = true)
    protected GraduationPlanType graduationPlanType;
    protected Boolean individualPlan;
    @XmlElement(required = true)
    protected Credits totalCreditsRequired;
    protected List<CreditsBySubject> creditsBySubject;
    protected List<CreditsByCourse> creditsByCourse;

    /**
     * Gets the value of the graduationPlanType property.
     * 
     * @return
     *     possible object is
     *     {@link GraduationPlanType }
     *     
     */
    public GraduationPlanType getGraduationPlanType() {
        return graduationPlanType;
    }

    /**
     * Sets the value of the graduationPlanType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GraduationPlanType }
     *     
     */
    public void setGraduationPlanType(GraduationPlanType value) {
        this.graduationPlanType = value;
    }

    /**
     * Gets the value of the individualPlan property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIndividualPlan() {
        return individualPlan;
    }

    /**
     * Sets the value of the individualPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIndividualPlan(Boolean value) {
        this.individualPlan = value;
    }

    /**
     * Gets the value of the totalCreditsRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Credits }
     *     
     */
    public Credits getTotalCreditsRequired() {
        return totalCreditsRequired;
    }

    /**
     * Sets the value of the totalCreditsRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Credits }
     *     
     */
    public void setTotalCreditsRequired(Credits value) {
        this.totalCreditsRequired = value;
    }

    /**
     * Gets the value of the creditsBySubject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditsBySubject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditsBySubject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditsBySubject }
     * 
     * 
     */
    public List<CreditsBySubject> getCreditsBySubject() {
        if (creditsBySubject == null) {
            creditsBySubject = new ArrayList<CreditsBySubject>();
        }
        return this.creditsBySubject;
    }

    /**
     * Gets the value of the creditsByCourse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditsByCourse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditsByCourse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditsByCourse }
     * 
     * 
     */
    public List<CreditsByCourse> getCreditsByCourse() {
        if (creditsByCourse == null) {
            creditsByCourse = new ArrayList<CreditsByCourse>();
        }
        return this.creditsByCourse;
    }

}
