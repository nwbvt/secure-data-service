//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 04:15:23 PM EST 
//


package org.ed_fi._0100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import com.sun.xml.bind.Locatable;
import com.sun.xml.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


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
 *         &lt;element name="StudentReference" type="{http://ed-fi.org/0100}StudentReferenceType"/>
 *         &lt;element name="AssessmentReference" type="{http://ed-fi.org/0100}AssessmentReferenceType"/>
 *         &lt;element name="StudentAssessment" type="{http://ed-fi.org/0100}SLC-StudentAssessment"/>
 *         &lt;element name="StudentObjectiveAssessment" type="{http://ed-fi.org/0100}SLC-StudentObjectiveAssessment"/>
 *         &lt;element name="StudentAssessmentItem" type="{http://ed-fi.org/0100}SLC-StudentAssessmentItem"/>
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
    "studentReferenceOrAssessmentReferenceOrStudentAssessment"
})
@XmlRootElement(name = "InterchangeStudentAssessment")
public class InterchangeStudentAssessment
    implements Locatable
{

    @XmlElements({
        @XmlElement(name = "StudentReference", type = StudentReferenceType.class),
        @XmlElement(name = "AssessmentReference", type = AssessmentReferenceType.class),
        @XmlElement(name = "StudentObjectiveAssessment", type = SLCStudentObjectiveAssessment.class),
        @XmlElement(name = "StudentAssessment", type = SLCStudentAssessment.class),
        @XmlElement(name = "StudentAssessmentItem", type = SLCStudentAssessmentItem.class)
    })
    protected List<Object> studentReferenceOrAssessmentReferenceOrStudentAssessment;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the studentReferenceOrAssessmentReferenceOrStudentAssessment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the studentReferenceOrAssessmentReferenceOrStudentAssessment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStudentReferenceOrAssessmentReferenceOrStudentAssessment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentReferenceType }
     * {@link AssessmentReferenceType }
     * {@link SLCStudentObjectiveAssessment }
     * {@link SLCStudentAssessment }
     * {@link SLCStudentAssessmentItem }
     * 
     * 
     */
    public List<Object> getStudentReferenceOrAssessmentReferenceOrStudentAssessment() {
        if (studentReferenceOrAssessmentReferenceOrStudentAssessment == null) {
            studentReferenceOrAssessmentReferenceOrStudentAssessment = new ArrayList<Object>();
        }
        return this.studentReferenceOrAssessmentReferenceOrStudentAssessment;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
