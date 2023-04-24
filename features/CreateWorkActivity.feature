Feature: Make an Activity

Scenario: A workActivity is made with a name
    When a new workActivity with the name "Start activity" is made
    Then The workActivity has the name "Start activity"