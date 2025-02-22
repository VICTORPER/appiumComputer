Feature: Filter a computer to the Page
  Background:

    Given  I am on the computer database page
  Scenario: Successfully filter a computer

    When I filter a computer by his name
      | computername |
      | Amiga 600    |
    Then The system only should show me the register filtered