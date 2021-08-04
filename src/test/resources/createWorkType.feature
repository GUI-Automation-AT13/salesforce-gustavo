Feature: Create workType

  @CreateWorkType
  Scenario: create an workType with only required fields
    Given I login to Salesforce site as an admin user
    When I navigate to "work Type" page in mode "Lightning"
    When I create a new workType only with required fields
      | Work Type Name     | workType test2 |
      | Estimated Duration | 2.00     |
    Then I verify WorkType created with requirement fields
    And I matches date and creator's name

  @CreateWorkType
  Scenario: create an workType
    Given I login to Salesforce site as an admin user
    When I navigate to "work Type" page in mode "Lightning"
    When I create a new workType with all fields
      | Work Type Name                | workType            |
      | Estimated Duration            | 25.00               |
      | Description                   | WorkTypeDescription |
      | Block Time Before Appointment | 3                   |
      | Block Time After Appointment  | 15                  |
      | Timeframe Start               | 4                   |
      | Timeframe End                 | 4                   |
    Then I verify WorkType created with requirement fields
    And I matches date and creator's name
