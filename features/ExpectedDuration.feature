Feature: expected duration of activity
Description: A project manager can register an expected duration on a work activity
Actors: Employee & project manager

#Scenario: A project manager sets expected duration on a work activity
#	Given an employee with the ID "ledr" exists
#	And an employee with the ID "ffna" exists
#	And a project with project number "23001" and project name "Project fireball" exists
#	And the project with project number "23001" has a project manager with the ID "ledr"
#	And the project has an activity with the name "Aktivitet1"
#	When the employee with the ID "ledr" registers "5" hours as the expected duration
  #Then the activity has "5" hours as the expected duration 

#Scenario: There is no project manager and an employee sets the expected duration
#	Given an employee with the ID "ffna" exists
#	And a project with project number "23001" and project name "Project fireball" exists
#	And the project has a workActivity with the name "Aktivitet1"
#	When the employee with the ID "ffna" registers "5" hours as the expected duration
  #Then the activity has "5" hours as the expected duration

#Scenario: There is a project manager and an employee sets the expected duration
#	Given an employee with the ID "ledr" exists
#	And an employee with the ID "ffna" exists
#	And a project with project number "23001" and project name "Project fireball" exists
#	And the project with project number "23001" has a project manager with the ID "ledr"
#	And the project has a workActivity with the name "Aktivitet1"
#	When the employee with the ID "ffna" registers "5" hours as the expected duration
#	Then the error message "Only the project manager can register expected duration" is given
#
#Scenario: the expected duration gets set to a negative value
#	Given an employee with the ID "ledr" exists
#	And an employee with the ID "ffna" exists
#	And a project with project number "23001" and project name "Project fireball" exists
#	And the project with project number "23001" has a project manager with the ID "ledr"
#	And the project has an activity with the name "Aktivitet1"
#	When the employee with the ID “ledr” registers "-5" hours as the expected duration
  #Then the error message "You can not register the expected duration as a negative value" is given
#	