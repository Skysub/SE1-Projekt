Feature: Divide a project into activities
  Description: An employee or a project manager divides a project into activities
  Actors: Employee or project manager

Scenario: Employee adds activity to a project without a project manager
    Given an employee with the ID "ffna" exists
    And a project with project number 23001 and project name "Time registration" exists
    And the project with project number 23001 does not have a project leader
    When the employee with ID "ffna" adds an activity with the name "new activity" to the project with ID 23001
    Then the project with ID 23001 has an activity with the name "new activity"

Scenario: Employee attempts to add an activity to a project with a project manager
    Given an employee with the ID "ffna" exists
    And an employee with the ID "ledr" exists
    And a project with project number 23001 and project name "Time registration" exists
    And the project with project number 23001 has a project manager with the ID "ledr"
    When the employee with ID "ffna" adds an activity with the name "new activity" to the project with ID 23001
    Then the error message "Only the project manager can create activities when there exists a project manager" is given

Scenario: Project manager adds activity to a project
    Given an employee with the ID "ffna" exists
    And a project with project number 23001 and project name "Time registration" exists
    And the project with project number 23001 has a project manager with the ID "ffna"
    When the employee with ID "ffna" adds an activity with the name "new activity" to the project with ID 23001
    Then the project with ID 23001 has an activity with the name "new activity"

Scenario: Activity already exists
    Given an employee with the ID "ffna" exists
    And a project with project number 23001 and project name "Time registration" exists
    And the employee with ID "ffna" adds an activity with the name "new activity" to the project with ID 23001
    When the employee with ID "ffna" adds an activity with the name "new activity" to the project with ID 23001
    Then the error message "An activity with the name new activity already exists" is given