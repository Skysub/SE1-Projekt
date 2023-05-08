#Skrevet af Frederik Cayré
Feature: Times used for activity

Scenario: A user registers time used
	Given a project with project number 23069 and project name "Time stuffs" exists
	And the project has a workActivity with the name "A1"
	And an employee with the ID "JJCB" exists
	When the employee with the ID "JJCB" registers 5 hours worked on the activity with the name "A1" in the project with ID 23069
	Then the activity has 5 hours of work registered for the employee with the ID "JJCB"
	And the employee with the ID "JJCB" has 5 hours of work registered that day
	
Scenario: A user tries to register negative time used
	Given a project with project number 23069 and project name "Time stuffs" exists
	And the project has a workActivity with the name "A1"
	And an employee with the ID "JJCB" exists
	When the employee with the ID "JJCB" registers -5 hours worked on the activity with the name "A1" in the project with ID 23069
	Then the error message "Cannot register negative time on an activity." is given

Scenario: A user wants to see time worked on an activity
	Given a project with project number 23420 and project name "Time stuffs" exists
	And the project has a workActivity with the name "Register time"
	And an employee with the ID "JJCB" exists
	When the employee with the ID "JJCB" registers 5 hours worked on the activity with the name "Register time" in the project with ID 23420
	Then the time the employee has worked on the activity is 5 hours

Scenario: A user wants to see time worked that day
	Given a project with project number 23420 and project name "Time stuffs" exists
	And the project has a workActivity with the name "Register time"
	And the project has a workActivity with the name "more time"
	And an employee with the ID "JJCB" exists
	When the employee with the ID "JJCB" registers 5 hours worked on the activity with the name "Register time" in the project with ID 23420
	And the employee with the ID "JJCB" registers 3 hours worked on the activity with the name "more time" in the project with ID 23420
	Then the employee with the ID "JJCB" has 8 hours of work registered that day
	
Scenario: A user wants to see time worked on a project
	Given a project with project number 23420 and project name "Time stuffs" exists
	And the project has a workActivity with the name "Register time"
	And the project has a workActivity with the name "more time"
	And an employee with the ID "JJCB" exists
	And an employee with the ID "ffna" exists
	When the employee with the ID "ffna" registers 2 hours worked on the activity with the name "more time" in the project with ID 23420
	And the employee with the ID "JJCB" registers 5 hours worked on the activity with the name "Register time" in the project with ID 23420
	And the employee with the ID "JJCB" registers 3 hours worked on the activity with the name "more time" in the project with ID 23420
	Then the employee with the ID "JJCB" has 8 hours of work registered on the project with ID 23420
	And the time the project with ID 23420 has been worked on is 10 hours