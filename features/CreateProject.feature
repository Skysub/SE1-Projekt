Feature: Create a project 
Description: A employee creates a project
Actors: Employee  

Scenario: Create a project successfully 
Given an employee with an identification number exist
And an assignment has been given
When the employee creates a project with project number “23001” and project name “Time registration” 
Then project with project number “23001” and project name “Time registration” exist

Scenario: Create a project that is already created 
Given an employee with an identification number exist
And project with project number “23001” and project name “Time registration” exist
When the employee creates a project with project number “23001” and project name “Time registration”
Then the error message “Project already exists” is given
