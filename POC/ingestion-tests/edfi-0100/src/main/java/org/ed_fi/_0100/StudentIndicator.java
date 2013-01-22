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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.sun.xml.bind.Locatable;
import com.sun.xml.bind.annotation.XmlLocation;
import org.xml.sax.Locator;


/**
 * An indicator or metric computed for the student (e.g., at risk) to influence more effective education or direct specific interventions.
 * 
 * <p>Java class for StudentIndicator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StudentIndicator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IndicatorGroup" type="{http://ed-fi.org/0100}IndicatorName" minOccurs="0"/>
 *         &lt;element name="IndicatorName" type="{http://ed-fi.org/0100}IndicatorName"/>
 *         &lt;element name="Indicator" type="{http://ed-fi.org/0100}Indicator"/>
 *         &lt;element name="BeginDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DesignatedBy" type="{http://ed-fi.org/0100}DesignatedBy" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StudentIndicator", propOrder = {
    "indicatorGroup",
    "indicatorName",
    "indicator",
    "beginDate",
    "endDate",
    "designatedBy"
})
public class StudentIndicator
    implements Locatable
{

    @XmlElement(name = "IndicatorGroup")
    protected String indicatorGroup;
    @XmlElement(name = "IndicatorName", required = true)
    protected String indicatorName;
    @XmlElement(name = "Indicator", required = true)
    protected String indicator;
    @XmlElement(name = "BeginDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar beginDate;
    @XmlElement(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;
    @XmlElement(name = "DesignatedBy")
    protected String designatedBy;
    @XmlLocation
    @XmlTransient
    protected Locator locator;

    /**
     * Gets the value of the indicatorGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatorGroup() {
        return indicatorGroup;
    }

    /**
     * Sets the value of the indicatorGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatorGroup(String value) {
        this.indicatorGroup = value;
    }

    /**
     * Gets the value of the indicatorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatorName() {
        return indicatorName;
    }

    /**
     * Sets the value of the indicatorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatorName(String value) {
        this.indicatorName = value;
    }

    /**
     * Gets the value of the indicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * Sets the value of the indicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicator(String value) {
        this.indicator = value;
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
     * Gets the value of the designatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignatedBy() {
        return designatedBy;
    }

    /**
     * Sets the value of the designatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignatedBy(String value) {
        this.designatedBy = value;
    }

    public Locator sourceLocation() {
        return locator;
    }

    public void setSourceLocation(Locator newLocator) {
        locator = newLocator;
    }

}
