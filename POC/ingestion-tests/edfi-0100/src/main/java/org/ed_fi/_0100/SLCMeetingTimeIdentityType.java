//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 04:15:23 PM EST 
//


package org.ed_fi._0100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import com.sun.xml.bind.Locatable;
import com.sun.xml.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


/**
 * New SLC identity type for MeetingTime.  Contains keyfields: embedded ClassPeriodReference and WeekNumber.
 * 
 * <p>Java class for SLC-MeetingTimeIdentityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SLC-MeetingTimeIdentityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClassPeriodReference" type="{http://ed-fi.org/0100}SLC-ClassPeriodReferenceType"/>
 *         &lt;element name="WeekNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SLC-MeetingTimeIdentityType", propOrder = {
    "classPeriodReference",
    "weekNumber"
})
public class SLCMeetingTimeIdentityType
    implements Locatable
{

    @XmlElement(name = "ClassPeriodReference", required = true)
    protected SLCClassPeriodReferenceType classPeriodReference;
    @XmlElement(name = "WeekNumber")
    protected int weekNumber;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the classPeriodReference property.
     * 
     * @return
     *     possible object is
     *     {@link SLCClassPeriodReferenceType }
     *     
     */
    public SLCClassPeriodReferenceType getClassPeriodReference() {
        return classPeriodReference;
    }

    /**
     * Sets the value of the classPeriodReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link SLCClassPeriodReferenceType }
     *     
     */
    public void setClassPeriodReference(SLCClassPeriodReferenceType value) {
        this.classPeriodReference = value;
    }

    /**
     * Gets the value of the weekNumber property.
     * 
     */
    public int getWeekNumber() {
        return weekNumber;
    }

    /**
     * Sets the value of the weekNumber property.
     * 
     */
    public void setWeekNumber(int value) {
        this.weekNumber = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
