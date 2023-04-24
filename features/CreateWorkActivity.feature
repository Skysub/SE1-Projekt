Feature: Make an Activity

Scenario: A workActivity is made with a name
    When a new workActivity with the name "Start activity" is made
    Then The workActivity has the name "Start activity"

Scenario: A workActivity is made with name and start week
    When a new workActivity with the name "Start activity" and start week 2 is made
    Then The workActivity has the name "Start activity"
    And The workActivity has the start week 2