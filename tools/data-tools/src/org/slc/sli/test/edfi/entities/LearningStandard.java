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
 * This entity is a subelement of a learning objective consisting of a precise statement of the expectation of a student's proficiency.
 * 
 * <p>Java class for LearningStandard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LearningStandard">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="LearningStandardId" type="{http://ed-fi.org/0100}LearningStandardId"/>
 *         &lt;element name="Description" type="{http://ed-fi.org/0100}Description"/>
 *         &lt;element name="ContentStandard" type="{http://ed-fi.org/0100}ContentStandardType"/>
 *         &lt;element name="GradeLevel" type="{http://ed-fi.org/0100}GradeLevelType"/>
 *         &lt;element name="SubjectArea" type="{http://ed-fi.org/0100}AcademicSubjectType"/>
 *         &lt;element name="CourseTitle" type="{http://ed-fi.org/0100}CourseTitle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LearningStandard", propOrder = {
    "learningStandardId",
    "description",
    "contentStandard",
    "gradeLevel",
    "subjectArea",
    "courseTitle"
})
public class LearningStandard
    extends ComplexObjectType
{

    @XmlElement(name = "LearningStandardId", required = true)
    protected LearningStandardId learningStandardId;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "ContentStandard", required = true)
    protected ContentStandardType contentStandard;
    @XmlElement(name = "GradeLevel", required = true)
    protected GradeLevelType gradeLevel;
    @XmlElement(name = "SubjectArea", required = true)
    protected AcademicSubjectType subjectArea;
    @XmlElement(name = "CourseTitle")
    protected String courseTitle;

    /**
     * Gets the value of the learningStandardId property.
     * 
     * @return
     *     possible object is
     *     {@link LearningStandardId }
     *     
     */
    public LearningStandardId getLearningStandardId() {
        return learningStandardId;
    }

    /**
     * Sets the value of the learningStandardId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LearningStandardId }
     *     
     */
    public void setLearningStandardId(LearningStandardId value) {
        this.learningStandardId = value;
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
     * Gets the value of the contentStandard property.
     * 
     * @return
     *     possible object is
     *     {@link ContentStandardType }
     *     
     */
    public ContentStandardType getContentStandard() {
        return contentStandard;
    }

    /**
     * Sets the value of the contentStandard property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContentStandardType }
     *     
     */
    public void setContentStandard(ContentStandardType value) {
        this.contentStandard = value;
    }

    /**
     * Gets the value of the gradeLevel property.
     * 
     * @return
     *     possible object is
     *     {@link GradeLevelType }
     *     
     */
    public GradeLevelType getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Sets the value of the gradeLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GradeLevelType }
     *     
     */
    public void setGradeLevel(GradeLevelType value) {
        this.gradeLevel = value;
    }

    /**
     * Gets the value of the subjectArea property.
     * 
     * @return
     *     possible object is
     *     {@link AcademicSubjectType }
     *     
     */
    public AcademicSubjectType getSubjectArea() {
        return subjectArea;
    }

    /**
     * Sets the value of the subjectArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcademicSubjectType }
     *     
     */
    public void setSubjectArea(AcademicSubjectType value) {
        this.subjectArea = value;
    }

    /**
     * Gets the value of the courseTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     * Sets the value of the courseTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseTitle(String value) {
        this.courseTitle = value;
    }

}
