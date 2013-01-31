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
 * <p>Java class for MagnetSpecialProgramEmphasisSchoolType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MagnetSpecialProgramEmphasisSchoolType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="All students participate"/>
 *     &lt;enumeration value="No students participate"/>
 *     &lt;enumeration value="Some, but not all, students participate"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MagnetSpecialProgramEmphasisSchoolType")
@XmlEnum
public enum MagnetSpecialProgramEmphasisSchoolType {

    @XmlEnumValue("All students participate")
    ALL_STUDENTS_PARTICIPATE("All students participate"),
    @XmlEnumValue("No students participate")
    NO_STUDENTS_PARTICIPATE("No students participate"),
    @XmlEnumValue("Some, but not all, students participate")
    SOME_BUT_NOT_ALL_STUDENTS_PARTICIPATE("Some, but not all, students participate");
    private final String value;

    MagnetSpecialProgramEmphasisSchoolType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MagnetSpecialProgramEmphasisSchoolType fromValue(String v) {
        for (MagnetSpecialProgramEmphasisSchoolType c: MagnetSpecialProgramEmphasisSchoolType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
