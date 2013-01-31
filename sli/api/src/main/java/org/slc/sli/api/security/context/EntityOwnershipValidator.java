package org.slc.sli.api.security.context;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slc.sli.api.config.EntityDefinition;
import org.slc.sli.api.config.EntityDefinitionStore;
import org.slc.sli.api.constants.EntityNames;
import org.slc.sli.api.constants.ParameterConstants;
import org.slc.sli.api.model.ModelProvider;
import org.slc.sli.api.resources.generic.util.ResourceHelper;
import org.slc.sli.api.util.SecurityUtil;
import org.slc.sli.domain.Entity;
import org.slc.sli.domain.NeutralCriteria;
import org.slc.sli.domain.NeutralQuery;
import org.slc.sli.modeling.uml.ClassType;
import org.slc.sli.modeling.uml.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EntityOwnershipValidator {

    private Set<String> publicEntities;
    private Map<String, Reference> typeToReference = new HashMap<String, EntityOwnershipValidator.Reference>();


    @Autowired
    private EntityDefinitionStore store;

    @Autowired
    private PagingRepositoryDelegate<Entity> repo;

    private static class Reference {
        //R2L = Right hand side entity contains reference to entity on left hand side
        //L2R = Left hand side entity contains reference to entity on right hand side
        public enum RefType {LEFT_TO_RIGHT, RIGHT_TO_LEFT};

        String fromType = null;
        String toType = null;
        RefType type = null;
        String refField = null;

        public Reference(String fromType, String toType, String refField, RefType refType) {
            this.fromType = fromType;
            this.toType = toType;
            this.type = refType;
            this.refField = refField;
        }

    }

    ClassType type = null;
    @SuppressWarnings({ "serial", "unused" })
    @PostConstruct
    private void init() {
        //studentSectionAssociationId->studentId->student
        typeToReference.put(EntityNames.STUDENT, new Reference(EntityNames.STUDENT, EntityNames.STUDENT_SCHOOL_ASSOCIATION, ParameterConstants.STUDENT_ID, Reference.RefType.RIGHT_TO_LEFT));
        typeToReference.put(EntityNames.STUDENT_SCHOOL_ASSOCIATION, new Reference(EntityNames.STUDENT_SCHOOL_ASSOCIATION, EntityNames.EDUCATION_ORGANIZATION, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.GRADE, new Reference(EntityNames.GRADE, EntityNames.STUDENT_SECTION_ASSOCIATION, ParameterConstants.STUDENT_SECTION_ASSOCIATION_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_SECTION_ASSOCIATION, new Reference(EntityNames.STUDENT_SECTION_ASSOCIATION, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.ATTENDANCE, new Reference(EntityNames.ATTENDANCE, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.COHORT, new Reference(EntityNames.COHORT, EntityNames.EDUCATION_ORGANIZATION, "educationOrgId", Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.COURSE, new Reference(EntityNames.COURSE, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.COURSE_OFFERING, new Reference(EntityNames.COURSE_OFFERING, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.COURSE_TRANSCRIPT, new Reference(EntityNames.COURSE_TRANSCRIPT, EntityNames.COURSE, ParameterConstants.COURSE_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.DISCIPLINE_INCIDENT, new Reference(EntityNames.DISCIPLINE_INCIDENT, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.DISCIPLINE_ACTION, new Reference(EntityNames.DISCIPLINE_ACTION, EntityNames.SCHOOL, "responsibilitySchoolId", Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.GRADEBOOK_ENTRY, new Reference(EntityNames.GRADEBOOK_ENTRY, EntityNames.SECTION, ParameterConstants.SECTION_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.GRADUATION_PLAN, new Reference(EntityNames.GRADUATION_PLAN, EntityNames.EDUCATION_ORGANIZATION, ParameterConstants.EDUCATION_ORGANIZATION_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.PARENT, new Reference(EntityNames.PARENT, EntityNames.STUDENT_PARENT_ASSOCIATION, ParameterConstants.PARENT_ID, Reference.RefType.RIGHT_TO_LEFT));
        typeToReference.put(EntityNames.REPORT_CARD, new Reference(EntityNames.REPORT_CARD, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.SECTION, new Reference(EntityNames.SECTION, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.SESSION, new Reference(EntityNames.SESSION, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STAFF, new Reference(EntityNames.STAFF, EntityNames.STAFF_ED_ORG_ASSOCIATION, ParameterConstants.STAFF_REFERENCE, Reference.RefType.RIGHT_TO_LEFT));
        typeToReference.put(EntityNames.STAFF_ED_ORG_ASSOCIATION, new Reference(EntityNames.STAFF_ED_ORG_ASSOCIATION, EntityNames.EDUCATION_ORGANIZATION, ParameterConstants.EDUCATION_ORGANIZATION_REFERENCE, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STAFF_COHORT_ASSOCIATION, new Reference(EntityNames.STAFF_COHORT_ASSOCIATION, EntityNames.STAFF, ParameterConstants.STAFF_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STAFF_PROGRAM_ASSOCIATION, new Reference(EntityNames.STAFF_PROGRAM_ASSOCIATION, EntityNames.STAFF, ParameterConstants.STAFF_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_ACADEMIC_RECORD, new Reference(EntityNames.STUDENT_ACADEMIC_RECORD, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_ASSESSMENT, new Reference(EntityNames.STUDENT_ASSESSMENT, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_COHORT_ASSOCIATION, new Reference(EntityNames.STUDENT_COHORT_ASSOCIATION, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_COMPETENCY, new Reference(EntityNames.STUDENT_COMPETENCY, EntityNames.STUDENT_SECTION_ASSOCIATION, ParameterConstants.STUDENT_SECTION_ASSOCIATION_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_COMPETENCY_OBJECTIVE, new Reference(EntityNames.STUDENT_COMPETENCY_OBJECTIVE, EntityNames.EDUCATION_ORGANIZATION, ParameterConstants.EDUCATION_ORGANIZATION_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_DISCIPLINE_INCIDENT_ASSOCIATION, new Reference(EntityNames.STUDENT_DISCIPLINE_INCIDENT_ASSOCIATION, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_PARENT_ASSOCIATION, new Reference(EntityNames.STUDENT_PARENT_ASSOCIATION, EntityNames.STUDENT, ParameterConstants.STUDENT_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_GRADEBOOK_ENTRY, new Reference(EntityNames.STUDENT_GRADEBOOK_ENTRY, EntityNames.GRADEBOOK_ENTRY, ParameterConstants.GRADEBOOK_ENTRY_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.STUDENT_PROGRAM_ASSOCIATION, new Reference(EntityNames.STUDENT_PROGRAM_ASSOCIATION, EntityNames.EDUCATION_ORGANIZATION, ParameterConstants.EDUCATION_ORGANIZATION_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.TEACHER_SECTION_ASSOCIATION, new Reference(EntityNames.TEACHER_SECTION_ASSOCIATION, EntityNames.STAFF, ParameterConstants.TEACHER_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.TEACHER_SCHOOL_ASSOCIATION, new Reference(EntityNames.TEACHER_SCHOOL_ASSOCIATION, EntityNames.SCHOOL, ParameterConstants.SCHOOL_ID, Reference.RefType.LEFT_TO_RIGHT));
        typeToReference.put(EntityNames.TEACHER, new Reference(EntityNames.TEACHER, EntityNames.STAFF_ED_ORG_ASSOCIATION, ParameterConstants.STAFF_REFERENCE, Reference.RefType.RIGHT_TO_LEFT));
        //typeToReference.put(EntityNames.STUDENT_GRADEBOOK_ENTRY, new Reference(EntityNames.STUDENT_GRADEBOOK_ENTRY, EntityNames.GRADEBOOK_ENTRY, ParameterConstants.GRADEBOOK_ENTRY_ID, Reference.RefType.LEFT_TO_RIGHT));
        publicEntities = new HashSet<String>(Arrays.asList(
                EntityNames.ASSESSMENT,
                EntityNames.COMPETENCY_LEVEL_DESCRIPTOR,
                EntityNames.EDUCATION_ORGANIZATION,
                EntityNames.SCHOOL,
                EntityNames.LEARNING_OBJECTIVE,
                EntityNames.LEARNING_STANDARD,
                EntityNames.PROGRAM,
                EntityNames.GRADING_PERIOD
                ));

    }

    public boolean canAccess(Entity entity) {

        if (publicEntities.contains(entity.getType())) {
            return true;
        }

        Set<String> owningEdorgs = lookupEdorgs(Arrays.asList(entity), entity.getType());
        if (owningEdorgs.size() == 0) {
            warn("Potentially bad data found.");
            return true;
        }

        for (String edOrgId : owningEdorgs) {
            if (SecurityUtil.getSLIPrincipal().getAuthorizingEdOrgs().contains(edOrgId)) {
                return true;
            }
        }
        return false;
    }

    private Set<String> lookupEdorgs(Iterable<Entity> entities, String entityType) {
        Set<String> edorgs = null;
        if (entityType.equals(EntityNames.EDUCATION_ORGANIZATION) || entityType.equals(EntityNames.SCHOOL) 
                || entityType.equals("stateEducationAgency") || entityType.equals("localEducationAgency")) {
            edorgs = new HashSet<String>();
            for (Entity entity : entities) {
                edorgs.add(entity.getEntityId());
            }
        } else {
            edorgs = lookupEdorgsForNonEdorgEntities(entities, entityType);
        }
        return edorgs;
    }


    /**
     * Look up the edorgs that can access the given entities.
     * @param entities
     * @param entityType
     * @return a Set of edorg IDs
     */
    private Set<String> lookupEdorgsForNonEdorgEntities(Iterable<Entity> entities, String entityType) {
        Set<String> edorgs = new HashSet<String>();
        Reference ref = typeToReference.get(entityType);
        if (ref == null) {
            warn("Cannot handle ownership for entity type {}.", entityType);
            throw new RuntimeException("No ownership for " + entityType);
        }

        for (Entity entity : entities) {
            EntityDefinition definition = store.lookupByEntityType(ref.toType);
            String collectionName = definition.getStoredCollectionName();
            String critField = null;
            String critValue = null;
            if (ref.type == Reference.RefType.LEFT_TO_RIGHT) {
                critField = ParameterConstants.ID;
                critValue = (String) entity.getBody().get(ref.refField);
            } else { //RIGHT_TO_LEFT
                critField = ref.refField;
                critValue = entity.getEntityId();
            }

            Iterable<Entity> ents = repo.findAll(collectionName, new NeutralQuery(new NeutralCriteria(critField, "=", critValue)));
            if (ents.iterator().hasNext()) {
                Set<String> toAdd = lookupEdorgs(ents, collectionName);
                edorgs.addAll(toAdd);
            } else {
                warn("Could not find a matching {} where {} is {}.", collectionName, critField, critValue);
            }
        }

        return edorgs;
    }
}
