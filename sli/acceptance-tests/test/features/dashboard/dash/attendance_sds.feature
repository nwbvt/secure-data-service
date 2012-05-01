Feature: Attendance in the dashboard

As a SEA/LEA user, I want to be able to see various
attendance data for a list of students.

Background:
    Given I have an open web browser
    Given the server is in "live" mode
  
@wip
Scenario: Teacher sees Absence Count in K-3 list of students view
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "Early Literacy View"
    Then the table includes header "Attendance"
      And I should see a table heading "Absence Count"
      And the count for id "attendances.absenceCount" for student "Charde Lowery" is "25" 
@wip
Scenario: Teacher sees Absence Count in 3-8 list of students view
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
        And I select view "Middle School ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Absence Count"
      And the count for id "attendances.absenceCount" for student "Charde Lowery" is "25"
 
 @wip
Scenario: Teacher sees Absence Count in 9-12 list of students view
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Absence Count"
      And the count for id "attendances.absenceCount" for student "Charde Lowery" is "13"

@wip
Scenario: Teacher sees Attendance Rate in 9-12 list of students view - red
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "IL_9-12"
    Then the table includes header "Attendance"
      And I should see a table heading "Attendance Rate %"
      And the count for id "attendances.attendanceRate" for student "Johnny Patel" is "87"
            And the class for id "attendances.attendanceRate" for student "Johnny Patel" is "perfLevel1"

@wip
Scenario: Teacher sees Attendance Rate in 9-12 list of students view - yellow 
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Attendance Rate %"
      And the count for id "attendances.attendanceRate" for student "Nomlanga Mccormick" is "94"
            And the class for id "attendances.attendanceRate" for student "Nomlanga Mccormick" is "perfLevel3"

@wip
Scenario: Teacher sees Attendance Rate in 9-12 list of students view - light green
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Attendance Rate %"
      And the count for id "attendances.attendanceRate" for student "Alec Swanson" is "95"
            And the class for id "attendances.attendanceRate" for student "Alec Swanson" is "perfLevel4"

@wip
Scenario: Teacher sees Attendance Rate in 9-12 list of students view - green
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Attendance Rate %"
      And the count for id "attendances.attendanceRate" for student "Marvin Miller" is "99"
            And the class for id "attendances.attendanceRate" for student "Marvin Miller" is "perfLevel5"

@wip
Scenario: Teacher sees Tardy Rate in 9-12 list of students view - red
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Rate %"
      And the count for id "attendances.tardyRate" for student "Arsenio Durham" is "13"
            And the class for id "attendances.tardyRate" for student "Arsenio Durham" is "perfLevel1"
@wip
Scenario: Teacher sees Tardy Rate in 9-12 list of students view - yellow
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Rate %"
      And the count for id "attendances.tardyRate" for student "Delilah Sims" is "6"
            And the class for id "attendances.tardyRate" for student "Delilah Sims" is "perfLevel3"

@wip
Scenario: Teacher sees Tardy Rate in 9-12 list of students view - light green 
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Rate %"
      And the count for id "attendances.tardyRate" for student "Jolene Ashley" is "4"
            And the class for id "attendances.tardyRate" for student "Jolene Ashley" is "perfLevel4"

@wip
Scenario: Teacher sees Tardy Rate in 9-12 list of students view - green 
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Rate %"
      And the count for id "attendances.tardyRate" for student "Charde Lowery" is "0"
            And the class for id "attendances.tardyRate" for student "Charde Lowery" is "perfLevel5"

@wip
 Scenario: Teacher sees Tardy Count in 9-12 list of students view - third color
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Count"
      And the count for id "attendances.tardyCount" for student "Arsenio Durham" is "28"
      And the class for id "attendances.tardyCount" for student "Arsenio Durham" is "countLevel4"

@wip
 Scenario: Teacher sees Tardy Count in 9-12 list of students view - second color
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Count"
      And the count for id "attendances.tardyCount" for student "Patricia Harper" is "4"
      And the class for id "attendances.tardyCount" for student "Patricia Harper" is "countLevel2"
      
@wip
 Scenario: Teacher sees Tardy Count in 9-12 list of students view - first color
    When I navigate to the Dashboard home page
    When I select "Sunset School District 4526" and click go
    When I login as "cgray" "cgray1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "Daybreak Central High"
        And I select <course> "American Literature"
        And I select <section> "Sec 145"
      And I select view "College Ready ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Count"
      And the count for id "attendances.tardyCount" for student "Charde Lowery" is "0"
      And the class for id "attendances.tardyCount" for student "Charde Lowery" is "countLevel1"

@integration
Scenario: Monster test until LOS is faster
    When I navigate to the Dashboard home page
    When I select "Illinois Sunset School District 4526" and click go
    When I login as "linda.kim" "linda.kim1234"
      When I select <edOrg> "Daybreak School District 4529"
        And I select <school> "East Daybreak Junior High"
        And I select <course> "8th Grade English"
        And I select <section> "8th Grade English - Sec 6"
      And I select view "Middle School ELA View"
    Then the table includes header "Attendance"
      And I should see a table heading "Tardy Count"
      And the count for id "attendances.tardyCount" for student "Rudy Bedoya" is "0"
      And the class for id "attendances.tardyCount" for student "Rudy Bedoya" is "color-widget-darkgreen"
      And I should see a table heading "Tardy Rate %"
      And the count for id "attendances.tardyRate" for student "Samantha Scorzelli" is "0"
      And the class for id "attendances.tardyRate" for student "Samantha Scorzelli" is "color-widget-darkgreen"
      And I should see a table heading "Attendance Rate %"
      And the count for id "attendances.attendanceRate" for student "Dominic Brisendine" is "100"
      And the class for id "attendances.attendanceRate" for student "Dominic Brisendine" is "color-widget-darkgreen"
      And the count for id "attendances.attendanceRate" for student "Lashawn Aldama" is "99"
      And the class for id "attendances.attendanceRate" for student "Lashawn Aldama" is "color-widget-darkgreen"
      And the count for id "attendances.attendanceRate" for student "Karrie Rudesill" is "100"
      And the class for id "attendances.attendanceRate" for student "Karrie Rudesill" is "color-widget-darkgreen"
      And the count for id "attendances.attendanceRate" for student "Lashawn Taite" is "86"
      And the class for id "attendances.attendanceRate" for student "Lashawn Taite" is "color-widget-red"
      And I should see a table heading "Absence Count"
      And the count for id "attendances.absenceCount" for student "Dominic Brisendine" is "0"
      And the class for id "attendances.absenceCount" for student "Dominic Brisendine" is "color-widget-darkgreen"
      And the count for id "attendances.absenceCount" for student "Felipe Cianciolo" is "6"
      And the class for id "attendances.absenceCount" for student "Felipe Cianciolo" is "color-widget-yellow"
       And the count for id "attendances.absenceCount" for student "Merry Mccanse" is "5"
      And the class for id "attendances.absenceCount" for student "Merry Mccanse" is "color-widget-green"
     

