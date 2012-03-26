
Feature: As an SLI application, I want to be able to manage assessments
As a SLI Application I want to be able to manage the basic model of assessments. This includes performing CRUD on Assessment entity.
Also verify the correct links from assessment to student-assessment associations and family-assessment associations. An assessment can 
be used to measure differences in individuals or groups and changes in performance from one occasion to the next.


This is the data I am assuming for these tests
assessmentTitle: Mathematics Achievement Assessment Test, Writing Advanced Placement Test
academicSubject: Mathematics, Writing, Foreign Language
gradeLevelAssessed: Adult
contentStandard: School Standard
assessmentCategory: Achievement  Test,  Advanced Placement Test

Background: Logged in as a super-user and using the small data set
  	Given I am logged in using "demo" "demo1234" to realm "SLI"

## JSON
Scenario: Create an assessment 
	Given format "application/json"
		And "assessmentTitle" is "Mathematics Achievement Assessment Test"
		And "assessmentIdentificationCode" is "01234B"
		And "academicSubject" is "Mathematics"
		And "assessmentCategory" is "Achievement test"
		And "gradeLevelAssessed" is "Adult Education"
		And "contentStandard" is "LEA Standard"
		And "version" is "2"
	When I navigate to POST "/assessments/"
	Then I should receive a return code of 201
		And I should receive an ID for the newly created assessment
    When I navigate to GET "/assessments/<'newly created assessment' ID>"
    Then "assessmentIdentificationCode" should be "01234B"
        And "academicSubject" should be "Mathematics"
        And "assessmentCategory" should be "Achievement test"
        And "gradeLevelAssessed" should be "Adult Education"
        And "contentStandard" should be "LEA Standard"
        And "version" should be "2"

Scenario: Read an assessment by ID
	Given format "application/json"
	When I navigate to GET "/assessments/<'Writing Advanced Placement Test' ID>"
	Then I should receive a return code of 200
		And "assessmentTitle" should be "Writing Advanced Placement Test"
		And "academicSubject" should be "English Language and Literature"
		And "assessmentCategory" should be "Advanced Placement"
        And I should receive a link named "self" with URI "/assessments/<'Writing Advanced Placement Test' ID>"
        And I should receive a link named "getStudentAssessmentAssociations" with URI "/student-assessment-associations/<'Writing Advanced Placement Test' ID>"
       	And I should receive a link named "getStudents" with URI "/student-assessment-associations/<'Writing Advanced Placement Test' ID>/targets"
       	And I should receive a link named "getSectionAssessmentAssociations" with URI "/section-assessment-associations/<'Writing Advanced Placement Test' ID>"
       	And I should receive a link named "getSections" with URI "/section-assessment-associations/<'Writing Advanced Placement Test' ID>/targets"
     	#And I should receive a link named "getAssessmentFamily" with URI "/assessment-family-associations/<'Writing Advanced Placement Test' ID>"


Scenario: Update an assessment by ID
	Given format "application/json"
		When I navigate to GET "/assessments/<'Writing Assessment II' ID>"
		Then I should receive a return code of 200
		And "assessmentTitle" should be "Writing Advanced Placement Test"
	When I set the "assessmentTitle" to "Advanced Placement Test - Subject: Writing"
		And I navigate to PUT "/assessments/<'Writing Assessment II' ID>"
	Then I should receive a return code of 204
	When I navigate to GET "/assessments/<'Writing Assessment II' ID>"
	Then I should receive a return code of 200
	And "assessmentTitle" should be "Advanced Placement Test - Subject: Writing"

Scenario: Delete an assessment by ID
	Given format "application/json"
	When I navigate to DELETE "/assessments/<'Mathematics Assessment 2' ID>"
	Then I should receive a return code of 204
	When I navigate to GET "/assessments/<'Mathematics Assessment 2' ID>"
	Then I should receive a return code of 404

## ERROR HANDLING
Scenario: Attempt to read a non-existent assessment
   Given format "application/json"
   When I navigate to GET "/assessments/<'NonExistentAssessment' ID>"
   Then I should receive a return code of 404

Scenario: Attempt to update a non-existent assessment
   Given format "application/json"
   When I attempt to update "/assessments/<'NonExistentAssessment' ID>"
   Then I should receive a return code of 404

Scenario: Attempt to delete a non-existent assessment
   Given format "application/json"
   When I navigate to DELETE "/assessments/<'NonExistentAssessment' ID>"
   Then I should receive a return code of 404
 
Scenario: Fail when asking for an unsupported format "text/plain"
    Given format "text/plain"
    When I navigate to GET "/assessments/<'Mathematics Assessment 3' ID>"
    Then I should receive a return code of 406
    
Scenario: Fail if going to the wrong URI
    Given format "application/json"
    When I navigate to GET "/assessment/<'WrongURI' ID>"
    Then I should receive a return code of 404
   
