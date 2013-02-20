/*
 * Copyright 2012-2013 inBloom, Inc. and its affiliates.
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

package org.slc.sli.api.security.context.validator;

import org.slc.sli.api.constants.EntityNames;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;

/**
 * Validates the context of a staff member to see the requested set of education organizations.
 * Returns true if the staff member can see ALL of the education organizations, and false otherwise.
 * 
 * This validator is used for both Write access to update a school, and accessing other entities through a school
 */
@Component
public class StaffToEdOrgValidator extends AbstractContextValidator {

    @Override
    public boolean canValidate(String entityType, boolean isTransitive) {
        return (EntityNames.SCHOOL.equals(entityType) || EntityNames.EDUCATION_ORGANIZATION.equals(entityType)) && isStaff();
    }

    @Override
    public boolean validate(String entityType, Set<String> ids) throws IllegalStateException {
        if (!areParametersValid(Arrays.asList(EntityNames.SCHOOL, EntityNames.EDUCATION_ORGANIZATION), entityType, ids)) {
            return false;
        }
        boolean match = true;
        Set<String> edOrgLineage = getStaffEdOrgLineage();
        for (String id : ids) {
            if (!edOrgLineage.contains(id)) {
                match = false;
                break;
            }
        }
        return match;
    }

}
