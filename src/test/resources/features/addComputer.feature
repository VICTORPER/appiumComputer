Feature: Add a new computer to the database

  Scenario: Successfully add a new computer
    Given Eli is on the computer database page
    When he adds a new computer with the following details:
      | name           | introduced  | discontinued | company |
      | Test Computer | 2023-10-01  | 2024-10-01   | Apple Inc.   |
    Then he should see a success message