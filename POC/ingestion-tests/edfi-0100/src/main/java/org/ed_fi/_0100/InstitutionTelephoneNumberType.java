//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 04:15:23 PM EST 
//


package org.ed_fi._0100;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstitutionTelephoneNumberType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstitutionTelephoneNumberType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Main"/>
 *     &lt;enumeration value="Administrative"/>
 *     &lt;enumeration value="HealthClinic"/>
 *     &lt;enumeration value="Attendance"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Fax"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstitutionTelephoneNumberType")
@XmlEnum
public enum InstitutionTelephoneNumberType {

    @XmlEnumValue("Main")
    MAIN("Main"),
    @XmlEnumValue("Administrative")
    ADMINISTRATIVE("Administrative"),
    @XmlEnumValue("HealthClinic")
    HEALTH_CLINIC("HealthClinic"),
    @XmlEnumValue("Attendance")
    ATTENDANCE("Attendance"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Fax")
    FAX("Fax");
    private final String value;

    InstitutionTelephoneNumberType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstitutionTelephoneNumberType fromValue(String v) {
        for (InstitutionTelephoneNumberType c: InstitutionTelephoneNumberType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
