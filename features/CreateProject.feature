#Skrevet og implementeret af Naila
Feature: Create a project
    Description: A employee creates a project
    Actors: Employee

Scenario: Create a project successfully
    Given an employee with the ID "ffna" exists
    When the employee creates a project with project number 23001 and project name "Time registration"
    Then the project with project number 23001 and project name "Time registration" exists

  Scenario: Create a project that is already created
    Given an employee with the ID "ffna" exists
    And a project with project number 23001 and project name "Time registration" exists
    When the employee creates a project with project number 23001 and project name "Time registration"
    Then the error message "Project already exists" is given

