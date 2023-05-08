#Skrevet af Frederik Cayré
Feature: Add a description to activities and projects - Frederik 
	Description: Descriptions for better understanding of either the project or the activity
	Actors: Employee  

Scenario: Employee sets a description to a project
	Given a project with project number 23069 and project name "proj1" exists
	When an employee sets the description "This is a project description" to the project
	Then the project has the description "This is a project description"

Scenario: Employee sets a description to an activity
	Given an activity with the name "New activity" exists
	When an employee sets the description "This is a description for akt" to the activity
	Then the activity has the description "This is a description for akt"
			
#Scenario: Employee sets a description to a template
#	Given a project with project number 23069 and project name "proj1" exists
#	When an employee sets the description "This is a project description" to the project
#	Then the project has the description "This is a project description"