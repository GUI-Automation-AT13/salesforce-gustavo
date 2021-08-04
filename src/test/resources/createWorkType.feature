Feature: Create workType

  @CreateWorkType
  Scenario: create an workType with only required fields
    Given I login to Salesforce site as an admin user
    When I navigate to "work Type" page in mode "Lightning"
      And I create a new workType only with required fields
      | Work Type Name     | workType |
      | Estimated Duration | 2.00     |
    Then I verify WorkType created with requirement fields
      And I matches date and creator's name

  @CreateWorkType
  Scenario: create an workType
    Given I login to Salesforce site as an admin user
    When I navigate to "work Type" page in mode "Lightning"
      And I create a new workType with all fields
      | Work Type Name                | workType                 |
      | Estimated Duration            | 25.00                    |
      | Duration Type                 | Minutes                  |
      | Description                   | WorkTypeDescription      |
      | Operating Hours               | OperatingHours-test news |
      | Block Time Before Unit        | Minute(s)                |
      | Block Time Before Appointment | 3                        |
      | Block Time After Unit         | Minute(s)                |
      | Block Time After Appointment  | 15                       |
      | Timeframe Start               | 4                        |
      | Time Frame Start Unit         | Day(s)                   |
      | Timeframe End                 | 4                        |
      | Time Frame End Unit           | Day(s)                   |
    Then I verify WorkType created with requirement fields
      And I matches date and creator's name
