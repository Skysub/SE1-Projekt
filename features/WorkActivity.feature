#Skrevet af Frederik Hvarregaard
Feature: Workactivity stuff, idk lav et nyt navn

Scenario: An employee is assigned to Activity
    Given an activity with the name "New activity" exists
    And an employee with the ID "JJCB" exists
    When the employee with the ID "JJCB" is added to the activity
    Then the activity has the employee with initials "JJCB"
    And the employee with the ID "JJCB" has the activity with name "New activity"