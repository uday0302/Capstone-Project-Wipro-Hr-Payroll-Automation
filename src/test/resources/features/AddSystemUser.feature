Feature: Add System User in OrangeHRM

  Scenario: Positive - Add a new system user
    Given I launch the application with "correct"
    Given I am logged out
    When I login with username "<username>" and password "<password>"
    And I navigate to Admin 
    And I navigate to User Management
    And I navigate to Users
    And I navigate to Add User
    When I enter user details:
      | role        | ESS           |
      | employee    | Ramesh Rajnan |
      | username    | testUser123   |
      | status      | Enabled       |
      | password    | Testt@12345   |
      | confirmpwd  | Testt@12345   |
    And I click on Save
    Then I should see a success message "Successfully Saved"

  Scenario: Negative - Add user with missing required fields
    Given I am logged out
    When I login with username "<username>" and password "<password>"
    And I navigate to Admin 
    And I navigate to User Management
    And I navigate to Users
    And I navigate to Add User
    When I enter user details:
      | role        | Admin         |
      | employee    |               |
      | username    |               |
      | status      | Enabled       |
      | password    | Test@12345     |
      | confirmpwd  | Test@12345     |
    And I click on Save
    Then I should see a validation error message "Required"
    
