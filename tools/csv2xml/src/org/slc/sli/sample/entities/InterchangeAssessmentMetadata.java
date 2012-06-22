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
// Generated on: 2012.04.20 at 03:09:04 PM EDT 
//


package org.slc.sli.sample.entities;

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
 *         &lt;element name="AssessmentFamily" type="{http://ed-fi.org/0100}AssessmentFamily"/>
 *         &lt;element name="Assessment" type="{http://ed-fi.org/0100}Assessment"/>
 *         &lt;element name="AssessmentPeriodDescriptor" type="{http://ed-fi.org/0100}AssessmentPeriodDescriptor"/>
 *         &lt;element name="PerformanceLevelDescriptor" type="{http://ed-fi.org/0100}PerformanceLevelDescriptor"/>
 *         &lt;element name="ObjectiveAssessment" type="{http://ed-fi.org/0100}ObjectiveAssessment"/>
 *         &lt;element name="AssessmentItem" type="{http://ed-fi.org/0100}AssessmentItem"/>
 *         &lt;element name="LearningObjective" type="{http://ed-fi.org/0100}LearningObjective"/>
 *         &lt;element name="LearningStandard" type="{http://ed-fi.org/0100}LearningStandard"/>
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
    "assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor"
})
@XmlRootElement(name = "InterchangeAssessmentMetadata")
public class InterchangeAssessmentMetadata {

    @XmlElements({
        @XmlElement(name = "Assessment", type = Assessment.class),
        @XmlElement(name = "ObjectiveAssessment", type = ObjectiveAssessment.class),
        @XmlElement(name = "PerformanceLevelDescriptor", type = PerformanceLevelDescriptor.class),
        @XmlElement(name = "AssessmentPeriodDescriptor", type = AssessmentPeriodDescriptor.class),
        @XmlElement(name = "AssessmentFamily", type = AssessmentFamily.class),
        @XmlElement(name = "LearningObjective", type = LearningObjective.class),
        @XmlElement(name = "LearningStandard", type = LearningStandard.class),
        @XmlElement(name = "AssessmentItem", type = AssessmentItem.class)
    })
    protected List<ComplexObjectType> assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor;

    /**
     * Gets the value of the assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assessment }
     * {@link ObjectiveAssessment }
     * {@link PerformanceLevelDescriptor }
     * {@link AssessmentPeriodDescriptor }
     * {@link AssessmentFamily }
     * {@link LearningObjective }
     * {@link LearningStandard }
     * {@link AssessmentItem }
     * 
     * 
     */
    public List<ComplexObjectType> getAssessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor() {
        if (assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor == null) {
            assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor = new ArrayList<ComplexObjectType>();
        }
        return this.assessmentFamilyOrAssessmentOrAssessmentPeriodDescriptor;
    }

}
