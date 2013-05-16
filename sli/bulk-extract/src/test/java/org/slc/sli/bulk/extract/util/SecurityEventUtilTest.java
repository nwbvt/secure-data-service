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
package org.slc.sli.bulk.extract.util;

import org.junit.Test;
import org.slc.sli.common.util.logging.LogLevelType;
import org.slc.sli.common.util.logging.SecurityEvent;

import java.lang.management.ManagementFactory;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test for the SecurityEventUtil class.
 * @author npandey
 */
public class SecurityEventUtilTest {



    /**
     * Test that the security even object is created as expected.
     */
    @Test
    public void testSEValues() {
        SecurityEvent event = SecurityEventUtil.createSecurityEvent("class", "Test security event message", "Action Description", LogLevelType.TYPE_INFO);
        assertEquals("BulkExtract", event.getAppId());
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        assertEquals(processName, event.getProcessNameOrId());
        assertEquals(null, event.getTargetEdOrg());
    }
}
