#Skrevet af Frederik Cayré
Feature: A project leader can assign employees to activities -Oliver

Description: The ability to assign employees to activities for the project manager. The employee should not be able to do so, thus they receive an error.
Actors: Project leader, employee

main scenario
Scenario: Project manager assigns an employee to a workActivity
	Given an employee with the ID "ledr" exists
	And an employee with the ID "ffna" exists
	And a project with project number 23001 and project name "Project fireball" exists
	And the project with project number 23001 has a project manager with the ID "ledr"
	And the project has a workActivity with the name "Aktivitet1"
	When the project manager assigns the employee with the ID "ffna" to the workActivity
	Then the employee with the ID "ffna" has the activity with name "Aktivitet1"
	And the activity in the project has the employee with initials "ffna"

Scenario: Project leader assigns an employee to the workActivity activity1, when the employee already is assigned to activity1
	Given an employee with the ID "ledr" exists
	And an employee with the ID "ffna" exists
	And a project with project number 23001 and project name "Project fireball" exists
	And the project with project number 23001 has a project manager with the ID "ledr"
	And the project has a workActivity with the name "Aktivitet1"
	And the project manager assigns the employee with the ID "ffna" to the workActivity
	When the project manager assigns the employee with the ID "ffna" to the workActivity
	Then the error message "The employee with ID ffna is already assigned to this activity" is given

Scenario: An employee tries to assign themselves to an activity when there is a project leader
	Given an employee with the ID "ledr" exists
	And an employee with the ID "ffna" exists
	And a project with project number 23001 and project name "Project fireball" exists
	And the project with project number 23001 has a project manager with the ID "ledr"
	And the project has a workActivity with the name "Aktivitet1"
	When the employee with the ID "ffna" assigns the employee with the ID "ffna" to the workActivity
	Then the error message "Only the project manager can assign employees when a project manager exists" is given

Scenario: An employee tries to assign themselves to an activity when there is no project leader
	Given an employee with the ID "ffna" exists
	And a project with project number 23001 and project name "Project Fireball" exists
	And the project has a workActivity with the name "Aktivitet1"
	When the employee with the ID "ffna" assigns the employee with the ID "ffna" to the workActivity
	Then the employee with the ID "ffna" has the activity with name "Aktivitet1"
	And the activity in the project has the employee with initials "ffna"


Scenario: Overview of the employees available at the time the activity should be done
	Given an employee with the ID "ffna" exists
	And an employee with the ID "JJCB" exists
	And an employee with the ID "ledr" exists
	And an activity with the name "Akt" exists
	And the employee with the ID "ffna" is added to the activity
	And the employee with the ID "JJCB" is added to the activity
	And the employee with the ID "ledr" is added to the activity
	And the activity has a start week of 9 and an end week of 13  
	When the employee searches for available employees around week 14
	Then the employee gets a list of employees with the IDs "ffna" and "JJCB" and "ledr"

Scenario: Overview of the employees available at a time the activity is not done
	Given an employee with the ID "ffna" exists
	And an employee with the ID "JJCB" exists
	And an employee with the ID "ledr" exists
	And an activity with the name "Akt" exists
	And the employee with the ID "ffna" is added to the activity
	And the employee with the ID "JJCB" is added to the activity
	And the employee with the ID "ledr" is added to the activity
	And the activity has a start week of 9 and an end week of 13  
	When the employee searches for available employees around week 12
	Then the employee gets an empty employee list