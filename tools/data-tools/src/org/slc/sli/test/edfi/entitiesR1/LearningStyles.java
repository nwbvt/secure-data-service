//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.17 at 02:49:01 PM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * The student's relative preference to visual,
 * 				auditory and tactile
 * 				learning expressed as percentages.
 * 			
 * 
 * <p>Java class for learningStyles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="learningStyles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="visualLearning" type="{}percent"/>
 *         &lt;element name="auditoryLearning" type="{}percent"/>
 *         &lt;element name="tactileLearning" type="{}percent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "learningStyles", propOrder = {
    "visualLearning",
    "auditoryLearning",
    "tactileLearning"
})
public class LearningStyles {

    protected int visualLearning;
    protected int auditoryLearning;
    protected int tactileLearning;

    /**
     * Gets the value of the visualLearning property.
     * 
     */
    public int getVisualLearning() {
        return visualLearning;
    }

    /**
     * Sets the value of the visualLearning property.
     * 
     */
    public void setVisualLearning(int value) {
        this.visualLearning = value;
    }

    /**
     * Gets the value of the auditoryLearning property.
     * 
     */
    public int getAuditoryLearning() {
        return auditoryLearning;
    }

    /**
     * Sets the value of the auditoryLearning property.
     * 
     */
    public void setAuditoryLearning(int value) {
        this.auditoryLearning = value;
    }

    /**
     * Gets the value of the tactileLearning property.
     * 
     */
    public int getTactileLearning() {
        return tactileLearning;
    }

    /**
     * Sets the value of the tactileLearning property.
     * 
     */
    public void setTactileLearning(int value) {
        this.tactileLearning = value;
    }

}
