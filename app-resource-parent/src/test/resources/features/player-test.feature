Feature: Player DAO Management

  Scenario: Successfully saving and retrieving a customer from the database
    Given the player database is empty
    When a user saves a new player named "Alice"
    Then a player named "Alice" should exist in the database
