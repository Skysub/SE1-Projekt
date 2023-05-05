Feature: Times used for activity - Frederik Hvarregaard

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

#Scenario: A user wants to see time worked on an activity
#	Given a project with project number 23420 and project name "time worked" exists
#	And the project has an activity with the name "register time"
#	And an employee with the ID "JJCB" exists
#	And the employee registers 5 hours used on the activity
#	When the employee checks how much time the employee has worked on the activity
#	Then the time the employee has worked on the activity is 5 hours
#
#Scenario: A user wants to see time worked that day
#	Given a project with project number 23420 and project name "time worked" exists
#	And the project has an activity with the name "register time"
#	And an employee with the ID "JJCB" exists
#	And the employee registers 5 hours used on the activity
#	And the project has an activity with the name "more time"
#	And the employee registers 3 hours used on the activity
#	When the employee checks how much time the employee has worked on that day
#	Then the time the employee has worked that day is 8 hours