Feature: Add personal activities - Frederik Hvarregaard
	Description: Adding personal activities such as vacation

Scenario: An employee adds vacation
	Given an employee with the ID "JJCB" exists
	And a the employee with the ID "JJCB" has a personal activity with the name "vac"
	And the personal activity has a start week of 9 and an end week of 13
	When the employee marks the personal activity as a vacation
	Then the employee with the ID "JJCB" has a registered vacation from week 9 until week 13

Scenario: An employee is added to an activity while on vacation during entire activity
	Given an employee with the ID "JJCB" exists
	And a the employee with the ID "JJCB" has a personal activity with the name "vac"
	And the personal activity has a start week of 9 and an end week of 13
	And the employee marks the personal activity as a vacation
	And a project with project number 23069 and project name "stuff" exists
	And the project has a workActivity with the name "workwork"
	And the activity with the ID "workwork" in the project with ID 23069 has a start week of 10 and an end week of 12 
	When the employee with the ID "JJCB" assigns the employee with the ID "JJCB" to the workActivity
	Then the error message "User ffna is on vacation during entire activity" is given
	
#Scenario: An employee is added to an activity while on vacation for some of the activity
#	Given an employee with the ID "JJCB" exists
#	And a the employee with the ID "JJCB" has a personal activity with the name "vac"
#	And the personal activity has a start week of 9 and an end week of 13
#	And the employee marks the personal activity as a vacation
#	And a project with project number 23069 and project name "stuff" exists
#	And the project has a workActivity with the name "workwork"
#	And the activity has a start week of 5 and an end week of 12 
#	When the employee with the ID "JJCB" assigns the employee with the ID "JJCB" to the workActivity
#	Then the employee with the ID "JJCB" has a registered vacation from week 9 until week 13
