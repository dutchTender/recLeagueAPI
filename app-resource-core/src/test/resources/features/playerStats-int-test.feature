Feature: PlayerStats DAO Management

  Scenario: Successfully saving and retrieving a PlayerStat from the database
    Given the Player and PlayerStats database is not empty
    When a user saves a new PlayerStat for a Player named "nick"
    Then a playerStat should exist for a Player named "nick" should exist in the database