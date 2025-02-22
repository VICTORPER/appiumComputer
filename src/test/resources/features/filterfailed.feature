Feature: Filter failed

  Scenario: Failed filter due user nothing type on filter field
    Given  I am on the computer database page
    When I filter failed a computer
      | computername |
      |     |
    Then The system show alert message