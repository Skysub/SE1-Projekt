#Skrevet af Frederik Cayré
Feature: An employee registers when they are sick
	Description: The employee can create a sickness activity under personal activities and others can check when they have been sick.
	
Scenario: A user becomes sick and sets a week as sick
	Given an employee with the ID "CORO" exists
	When the employee with ID "CORO" registers as sick during week 6
	Then the employee with the ID "CORO" has the personal activity with the name "Sick in week 6"
	And the personal activity has a start week of 6 and an end week of 6
	And the personal activity has the type "SICK"
	
Scenario: A user wants to see the amount of sick weeks within a period
	Given an employee with the ID "CORO" exists
	And the employee with ID "CORO" registers as sick during week 6
	And the employee with ID "CORO" registers as sick during week 11
	And the employee registers 16 sick workhours during week 6
	And the employee registers 8 sick workhours during week 11
	When the employee gets a sickness report between week 5 and week 12
	Then the report states the employee has been sick in week 6
	And the report states the employee has been sick in week 11
	And the report states the employee has has 24 sick hours in the period