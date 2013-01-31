//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.22 at 01:42:02 PM EST 
//


package org.ed_fi._0100;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssessmentItemResultType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AssessmentItemResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Correct"/>
 *     &lt;enumeration value="Incorrect"/>
 *     &lt;enumeration value="Met standard"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AssessmentItemResultType")
@XmlEnum
public enum AssessmentItemResultType {

    @XmlEnumValue("Correct")
    CORRECT("Correct"),
    @XmlEnumValue("Incorrect")
    INCORRECT("Incorrect"),
    @XmlEnumValue("Met standard")
    MET_STANDARD("Met standard");
    private final String value;

    AssessmentItemResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AssessmentItemResultType fromValue(String v) {
        for (AssessmentItemResultType c: AssessmentItemResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
