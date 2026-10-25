Feature: Game DAO Management

  Scenario: Successfully saving and retrieving a customer from the database
    Given the game database is empty
    When a user create a new game for the date "12/03/2026"
    Then a game dated "12/03/2026" should exist in the database