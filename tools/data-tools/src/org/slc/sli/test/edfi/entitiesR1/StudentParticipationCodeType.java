//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.08.31 at 10:43:34 AM EDT 
//


package org.slc.sli.test.edfi.entitiesR1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for studentParticipationCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="studentParticipationCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Victim"/>
 *     &lt;enumeration value="Perpetrator"/>
 *     &lt;enumeration value="Witness"/>
 *     &lt;enumeration value="Reporter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "studentParticipationCodeType")
@XmlEnum
public enum StudentParticipationCodeType {

    @XmlEnumValue("Victim")
    VICTIM("Victim"),
    @XmlEnumValue("Perpetrator")
    PERPETRATOR("Perpetrator"),
    @XmlEnumValue("Witness")
    WITNESS("Witness"),
    @XmlEnumValue("Reporter")
    REPORTER("Reporter");
    private final String value;

    StudentParticipationCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StudentParticipationCodeType fromValue(String v) {
        for (StudentParticipationCodeType c: StudentParticipationCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
