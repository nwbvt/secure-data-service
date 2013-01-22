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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * This entity represents the prescribed span of time when an education institution is open, instruction is provided, and students are under the direction and guidance of teachers and/or education institution administration. A session may be interrupted by one or more vacations.
 * 
 * <p>Java class for Session complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Session">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ed-fi.org/0100}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element name="SessionName" type="{http://ed-fi.org/0100}IdentificationCode"/>
 *         &lt;element name="SchoolYear" type="{http://ed-fi.org/0100}SchoolYearType"/>
 *         &lt;element name="Term" type="{http://ed-fi.org/0100}TermType"/>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="TotalInstructionalDays" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EducationOrganizationReference" type="{http://ed-fi.org/0100}EducationalOrgReferenceType"/>
 *         &lt;element name="GradingPeriodReference" type="{http://ed-fi.org/0100}GradingPeriodReferenceType" maxOccurs="unbounded"/>
 *         &lt;element name="CalendarDateReference" type="{http://ed-fi.org/0100}ReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AcademicWeekReference" type="{http://ed-fi.org/0100}ReferenceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Session", propOrder = {
    "sessionName",
    "schoolYear",
    "term",
    "beginDate",
    "endDate",
    "totalInstructionalDays",
    "educationOrganizationReference",
    "gradingPeriodReference",
    "calendarDateReference",
    "academicWeekReference"
})
public class Session
    extends ComplexObjectType
{

    @XmlElement(name = "SessionName", required = true)
    protected String sessionName;
    @XmlElement(name = "SchoolYear", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String schoolYear;
    @XmlElement(name = "Term", required = true)
    protected TermType term;
    @XmlElement(name = "BeginDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar beginDate;
    @XmlElement(name = "EndDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "TotalInstructionalDays")
    protected int totalInstructionalDays;
    @XmlElement(name = "EducationOrganizationReference", required = true)
    protected EducationalOrgReferenceType educationOrganizationReference;
    @XmlElement(name = "GradingPeriodReference", required = true)
    protected List<GradingPeriodReferenceType> gradingPeriodReference;
    @XmlElement(name = "CalendarDateReference")
    protected List<ReferenceType> calendarDateReference;
    @XmlElement(name = "AcademicWeekReference")
    protected List<ReferenceType> academicWeekReference;

    /**
     * Gets the value of the sessionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     * Sets the value of the sessionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionName(String value) {
        this.sessionName = value;
    }

    /**
     * Gets the value of the schoolYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolYear() {
        return schoolYear;
    }

    /**
     * Sets the value of the schoolYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolYear(String value) {
        this.schoolYear = value;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link TermType }
     *     
     */
    public TermType getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermType }
     *     
     */
    public void setTerm(TermType value) {
        this.term = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBeginDate(XMLGregorianCalendar value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the totalInstructionalDays property.
     * 
     */
    public int getTotalInstructionalDays() {
        return totalInstructionalDays;
    }

    /**
     * Sets the value of the totalInstructionalDays property.
     * 
     */
    public void setTotalInstructionalDays(int value) {
        this.totalInstructionalDays = value;
    }

    /**
     * Gets the value of the educationOrganizationReference property.
     * 
     * @return
     *     possible object is
     *     {@link EducationalOrgReferenceType }
     *     
     */
    public EducationalOrgReferenceType getEducationOrganizationReference() {
        return educationOrganizationReference;
    }

    /**
     * Sets the value of the educationOrganizationReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link EducationalOrgReferenceType }
     *     
     */
    public void setEducationOrganizationReference(EducationalOrgReferenceType value) {
        this.educationOrganizationReference = value;
    }

    /**
     * Gets the value of the gradingPeriodReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gradingPeriodReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGradingPeriodReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GradingPeriodReferenceType }
     * 
     * 
     */
    public List<GradingPeriodReferenceType> getGradingPeriodReference() {
        if (gradingPeriodReference == null) {
            gradingPeriodReference = new ArrayList<GradingPeriodReferenceType>();
        }
        return this.gradingPeriodReference;
    }

    /**
     * Gets the value of the calendarDateReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the calendarDateReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCalendarDateReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getCalendarDateReference() {
        if (calendarDateReference == null) {
            calendarDateReference = new ArrayList<ReferenceType>();
        }
        return this.calendarDateReference;
    }

    /**
     * Gets the value of the academicWeekReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the academicWeekReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAcademicWeekReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getAcademicWeekReference() {
        if (academicWeekReference == null) {
            academicWeekReference = new ArrayList<ReferenceType>();
        }
        return this.academicWeekReference;
    }

}
