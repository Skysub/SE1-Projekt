# Skrevet af Frederik Hvarregaard
Feature: Set-Up of an Employee

    Scenario: an Employee is made
        When a new employee profile with the ID "JJCB" is made
        Then The employee has the initials "JJCB"


    Scenario: an employee profile with 4 letters that already exists

        Given an employee with the ID "JJCB" exists
        When a new employee profile with the ID "JJCB" is made
        Then the error message "An employee with the ID already exists" is given

    
    Scenario: Employee creates an employee profile with less than 4 letters
        When a new employee profile with the ID "P" is made
        Then The employee has the initials "P"

    Scenario: Employee creates an employee profile with more than 4 letters
        When a new employee profile with the ID "JJJCB" is made
        Then the error message "Employee has too many initials" is given

    Scenario: Employee inputs information about the unique employee
        Given an employee with the ID "ffna" exists
        When the employee sets the title of the employee to "Senior Software Engineer"
        Then the title of the employee is "Senior Software Engineer"  

    Scenario: Employee updates a unique employee profile
        Given an employee with the ID "ffna" exists
        And the employee has the title "Sauceman"
        When the employee sets the title of the employee to "Senior Software Engineer"
        Then the title of the employee is "Senior Software Engineer"  

    Scenario: Employee deletes a unique employee

        Given an employee with the ID "ffna" exists
        When the employee deletes the employee profile 
        Then an employee with the ID "ffna" does not exist