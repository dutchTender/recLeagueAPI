Feature: PlayerStats DAO Management

  Scenario: Successfully saving and retrieving a PlayerStat from the database
    Given the Player and PlayerStats database is not empty
    When a user saves a new PlayerStat for a Player named "Alice"
    Then a playerStat should exist for a Player named "Alice" should exist in the database