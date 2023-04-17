Feature: Divide a project into activities
Description: A employee or a project manager divides a project into activities 
Actors: Employee or project manager  

Scenario: Employee adds activity to a project
Given an employee with an identification number exist
And project with project number “23001” and project name “Time registration” exist
When employee adds activity to project
Then project has activity

Scenario: Project manager adds activity to a project
Given a project manager with an identification number exist
And project with project number “23001” and project name “Time registration” exist
When project manager adds activity with name “New activity” to project
Then project has activity “New activity”

Scenario: Activity already exist
Given an employee with an identification number exist
And project with project number “23001” and project name “Time registration” exist
When employee adds activity with name “New activity” to project
Then the error message “Activity already exists” is given
