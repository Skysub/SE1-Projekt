Feature: Add personal activities - Frederik Hvarregaard
	Description: Adding personal activities such as vacation

Scenario: An employee adds vacation
	Given an employee with the ID "JJCB" exists
	And a the employee with the ID "JJCB" has a personal activity with the name "vac"
	And the personal activity has a start week of 9 and an end week of 13
	When the employee marks the personal activity as a vacation
	Then the employee with the ID "JJCB" has a registered vacation from week 9 until week 13

#Scenario: An employee is added to an activity while on vacation
#	Given an employee with the ID "feri" exists
#	Given a project with project number 23069 and project name "stuff" exists
#	And the project has an activity with the name "Not a ferie"
#	And the activity has a start week of 9 and an end week of 13 
#	When the employee assigns the employee to the activity
#	Then the error message "User is on vacation" is given
