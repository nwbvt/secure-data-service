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
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="StudentProgramAssociation" type="{http://ed-fi.org/0100}SLC-StudentProgramAssociation"/>
 *         &lt;element name="StudentSpecialEdProgramAssociation" type="{http://ed-fi.org/0100}StudentSpecialEdProgramAssociation"/>
 *         &lt;element name="RestraintEvent" type="{http://ed-fi.org/0100}RestraintEvent"/>
 *         &lt;element name="StudentCTEProgramAssociation" type="{http://ed-fi.org/0100}StudentCTEProgramAssociation"/>
 *         &lt;element name="StudentTitleIPartAProgramAssociation" type="{http://ed-fi.org/0100}StudentTitleIPartAProgramAssociation"/>
 *         &lt;element name="ServiceDescriptor" type="{http://ed-fi.org/0100}ServiceDescriptor"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent"
})
@XmlRootElement(name = "InterchangeStudentProgram")
public class InterchangeStudentProgram {

    @XmlElements({
        @XmlElement(name = "StudentTitleIPartAProgramAssociation", type = StudentTitleIPartAProgramAssociation.class),
        @XmlElement(name = "StudentSpecialEdProgramAssociation", type = StudentSpecialEdProgramAssociation.class),
        @XmlElement(name = "RestraintEvent", type = RestraintEvent.class),
        @XmlElement(name = "StudentCTEProgramAssociation", type = StudentCTEProgramAssociation.class),
        @XmlElement(name = "ServiceDescriptor", type = ServiceDescriptor.class),
        @XmlElement(name = "StudentProgramAssociation", type = SLCStudentProgramAssociation.class)
    })
    protected List<Object> studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent;

    /**
     * Gets the value of the studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentTitleIPartAProgramAssociation }
     * {@link StudentSpecialEdProgramAssociation }
     * {@link RestraintEvent }
     * {@link StudentCTEProgramAssociation }
     * {@link ServiceDescriptor }
     * {@link SLCStudentProgramAssociation }
     * 
     * 
     */
    public List<Object> getStudentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent() {
        if (studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent == null) {
            studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent = new ArrayList<Object>();
        }
        return this.studentProgramAssociationOrStudentSpecialEdProgramAssociationOrRestraintEvent;
    }

}
