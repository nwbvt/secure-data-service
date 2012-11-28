//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.16 at 01:39:34 PM EST 
//


package org.slc.sli.test.edfi.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * Encapsulates the possible attributes that can be used to lookup the identity of the Learning Objectives.
 * 
 * <p>Java class for LearningObjectiveIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LearningObjectiveIdentityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="LearningObjectiveId" type="{http://ed-fi.org/0100}LearningStandardId"/>
 *         &lt;element name="Objective" type="{http://ed-fi.org/0100}Objective"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LearningObjectiveIdentityType", propOrder = {
    "learningObjectiveIdOrObjective"
})
public class LearningObjectiveIdentityType {

    @XmlElements({
        @XmlElement(name = "Objective", type = String.class),
        @XmlElement(name = "LearningObjectiveId", type = LearningStandardId.class)
    })
    protected List<Object> learningObjectiveIdOrObjective;

    /**
     * Gets the value of the learningObjectiveIdOrObjective property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the learningObjectiveIdOrObjective property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLearningObjectiveIdOrObjective().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link LearningStandardId }
     * 
     * 
     */
    public List<Object> getLearningObjectiveIdOrObjective() {
        if (learningObjectiveIdOrObjective == null) {
            learningObjectiveIdOrObjective = new ArrayList<Object>();
        }
        return this.learningObjectiveIdOrObjective;
    }

}
