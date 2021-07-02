Feature: Create a new customer account
  Scenario: Customer creates new account
    Given The customer is on the create account page
    When  The customer fills out the correct fields with appropriate information
    When The customer clicks the create account button
    Then The customer should be notified that the account was created

  Scenario Outline:
    Given The customer is on the create account page
    When The customer enters their name as "<name>"
    When The customer enters their occupation as "<occupation>"
    When The customer enters their username as "<username>"
    When The customer enters their password as "<password>"
    When The customer selects a plan
    When The customer clicks the create account button
    Then The customer should be shown an error popup
    Examples:
    |name| occupation | username | password |
    |   | Valid input | Valid input1 | Valid input|
    | Valid input  |  | Valid input2 | Valid input|
    | Valid input  | Valid input |  | Valid input |
    | Valid input  | Valid input | Valid input3 | |
