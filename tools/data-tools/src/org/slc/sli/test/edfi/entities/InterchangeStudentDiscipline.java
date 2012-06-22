/*
 * Copyright 2012 Shared Learning Collaborative, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.05.31 at 09:35:49 AM EDT 
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
 *         &lt;element name="DisciplineIncident" type="{http://ed-fi.org/0100}DisciplineIncident"/>
 *         &lt;element name="StudentDisciplineIncidentAssociation" type="{http://ed-fi.org/0100}StudentDisciplineIncidentAssociation"/>
 *         &lt;element name="DisciplineAction" type="{http://ed-fi.org/0100}DisciplineAction"/>
 *         &lt;element name="BehaviorDescriptor" type="{http://ed-fi.org/0100}BehaviorDescriptor"/>
 *         &lt;element name="DisciplineDescriptor" type="{http://ed-fi.org/0100}DisciplineDescriptor"/>
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
    "disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction"
})
@XmlRootElement(name = "InterchangeStudentDiscipline")
public class InterchangeStudentDiscipline {

    @XmlElements({
        @XmlElement(name = "StudentDisciplineIncidentAssociation", type = StudentDisciplineIncidentAssociation.class),
        @XmlElement(name = "DisciplineIncident", type = DisciplineIncident.class),
        @XmlElement(name = "BehaviorDescriptor", type = BehaviorDescriptor.class),
        @XmlElement(name = "DisciplineDescriptor", type = DisciplineDescriptor.class),
        @XmlElement(name = "DisciplineAction", type = DisciplineAction.class)
    })
    protected List<Object> disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction;

    /**
     * Gets the value of the disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDisciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StudentDisciplineIncidentAssociation }
     * {@link DisciplineIncident }
     * {@link BehaviorDescriptor }
     * {@link DisciplineDescriptor }
     * {@link DisciplineAction }
     * 
     * 
     */
    public List<Object> getDisciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction() {
        if (disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction == null) {
            disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction = new ArrayList<Object>();
        }
        return this.disciplineIncidentOrStudentDisciplineIncidentAssociationOrDisciplineAction;
    }

}
