Feature: Team DAO Management

  Scenario: Successfully saving and retrieving a customer from the database
    Given the team database is empty
    When a user saves a new team named "Bulls"
    Then a team named "Bulls" should exist in the database