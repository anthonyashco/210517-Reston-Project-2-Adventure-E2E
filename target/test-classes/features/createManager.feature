Feature: Manager creates new account
  Background:
    Given The manager is on the login screen
  Scenario: Manager creates new account happy path
    Given The manager is on the create account page
    When The manager enters appropriate information
    When The manager clicks the create account button
    Then The manager should be notified the account was created and should be redirected to the login page

  Scenario Outline: Manager creates new account sad path
    Given The manager is on the create account page
    When The manager enters their name as "<name>"
    When The manager enters their username as "<username>"
    When The manager enters their password as "<password>"
    When The manager clicks the create account button
    Then The manager should be notified that something "<something>" went wrong.

    Examples:
      | name | username | password | something|
      |      | valid input1 | valid input | name |
      | valid input | | valid input | username |
      | valid input | valid input2 | | password |