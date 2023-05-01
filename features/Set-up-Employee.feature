
Feature: Set-Up of an Employee

    Scenario: an Employee is made
        When a new employee profile with the ID "JJCB" is made
        Then The employee has the initials "JJCB"


    Scenario: an employee profile with 4 letters that already exists

        Given an employee with the ID "JJCB" exists
        When a new employee profile with the ID "JJCB" is made
        Then the error message "An employee with the ID already exists" is given
