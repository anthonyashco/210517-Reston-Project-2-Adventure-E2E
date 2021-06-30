Feature: Customer Update Healthcare Plan

  Scenario Outline: Choose different plans sad
    Given	the customer is on the plans page
    When	the customer clicks the <plan> button
    Then	a confirmation window / popup appears
    When	the customer clicks the <button> button
    Then	the confirmation window / popup disappears

    Examples:
      | plan   | button  |
      | bronze | deny    |
      | silver | deny    |
      | gold   | deny    |

  Scenario Outline: Choose different plans happy
    Given	the customer is on the plans page
    When	the customer clicks the <plan> button
    Then	a confirmation window / popup appears
    When	the customer clicks the <button> button
    Then	the browser navigates to the claims page
    Then	<plan> is reflected on the navigation bar

    Examples:
      | plan   | button  |
      | bronze | confirm |
      | silver | confirm |
      | gold   | confirm |
