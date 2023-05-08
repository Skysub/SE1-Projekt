#Skrevet af Abdul og implementeret af Frederik Cayré Hede-Andersen
Feature: Work distribution
Description: Employees should be able to work on up to 20 activities during a week
Actors: Employee

Scenario: employee can have 20 activities at once
	Given an employee with the ID "JJCB" exists
	And 20 activities with start week 5 and end week 6 in the project with the ID 23001 exist
	And employees can be assigned a maximum of 20 activities per week
	And the employee is assigned the 19 activities
	When an employee with the ID "JJCB" is assigned the activity named "19" in the project with ID 23001
	Then the employee with initials "JJCB" is assigned to all the 20 activities of the project with ID 23001

Scenario: employee cannot have more than 20 activities at once
	Given an employee with the ID "JJCB" exists
	And 21 activities with start week 5 and end week 6 in the project with the ID 23001 exist
	And employees can be assigned a maximum of 20 activities per week
	And the employee is assigned the 20 activities
	When an employee with the ID "JJCB" is assigned the activity named "20" in the project with ID 23001
	Then the error message "Employees cannot be assigned more than 20 activities in a given week" is given
