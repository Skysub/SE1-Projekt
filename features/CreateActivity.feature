Feature: Divide a project into activities
  Description: An employee or a project manager divides a project into activities
  Actors: Employee or project manager

  Scenario: Employee adds activity to a project without a project manager
    Given an employee with the ID "ffna" exists
    And a project with project number 23001 and project name "Time registration" exists
    And the project with project number 23001 does not have a project leader
    When the employee with ID "ffna" adds an activity to the project
    Then the project has an activity

#  Scenario: Employee attempts to add an activity to a project with a project manager
#    Given an employee with the ID "ffna" exists
    #And an employee with the ID "ledr" exists
    #And a project with project number 23001 and project name "Time registration" exists
    #And the project with project number 23001 has a project manager with the ID "ledr"
    #When the employee with ID "ffna" adds activity to project
    #Then the error message "Only the project manager can create activities when there exists a project manager" is given
#
  #Scenario: Project manager adds activity to a project
    #Given an employee with the ID "ffna" exists
    #And a project with project number 23001 and project name "Time registration" exists
    #When project manager adds activity with name "New activity" to project
    #Then the project has activity "New activity"
#
  #Scenario: Activity already exists
    #Given an employee with the ID "ffna" exists
    #And a project with project number 23001 and project name "Time registration" exists
    #And an activity with the name “New activity” is part of the project
    #When the employee adds an activity with name “New activity” to the project
    #Then the error message “An activity with the name New activity already exists” is given
