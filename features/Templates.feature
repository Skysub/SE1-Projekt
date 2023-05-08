#Skrevet og implementeret af Frederik Cayré Hede-Andersen
Feature: Templates for easier project creation - Frederik 
  Description: Templates used by employees creating new projects to have a quicker start with standard boilerplate. Save projects as templates.
  Actors: Employee  

Scenario: Employee saves project as template
  Given a project with project number 23069 and project name "new proj" exists
	And the project has a workActivity with the name "theAkt"
  When an employee saves the project with ID 23069 as a template with the ID 1
  And the employee gives the template the name "new template"
  Then the template with ID 1 exists
  And the template with ID 1 has the name "new template"
  And the template with  ID 1 has an activity named "theAkt"

#Scenario: Employee creates a project based on a template
  #Given a template with the name "template1" and ID 1 exists
  #And the template has an activity named "the akt"
  #When an employee creates a project based on the template with project number 23420 and name "temp proj"
  #Then the project with with project number 23420 and project name "temp proj" exists
  #And the project has an activity with the name "the akt"
#
#Scenario: Employee changes a template’s name
  #Given a template with the name "template1" and ID 1 exists
  #When an employee changes the name of the template to the name "new temperplate"
  #Then the template with the name "new temperplate" and ID 1 exists
  #And a template with the name "template1" does not exists
#
#Scenario: Employee deletes a template
  #Given a template with the name "template1" and ID 1 exists
  #When an employee deletes the template with the ID 1
  #Then the template with the ID 1 does not exists
#
#Scenario: Employee makes a template the default
  #Given a template with the name "template1" and ID 1 exists
  #And a template with the name "template22Def" and ID 2 exists
  #And the template with the ID 2 is the default
  #When an employee makes the template with the ID 1 the default
  #Then the template with the ID 1 is the default
  #And the template with the ID 2 is not the default
