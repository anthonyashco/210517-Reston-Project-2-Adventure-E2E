Feature: Customer Browse Healthcare Plans

  Scenario: Customer Browse Plans
    Given the customer is logged into the UI
    When the customer clicks the shop plans button
    Then the browser navigates to the plans page
