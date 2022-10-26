# borrowing calculator
# Tags: optional
    
Feature: Login feature

Scenario Outline: Test Login function with valid username

  Given Open I launch chrome browser
  When I enter a valid "<Username>" and Valid "<Password>"
  Then The I click Login button
  And I verify that the user is succefully logged in

Examples:
  | Username      | Password     |
  | standard_user | secret_sauce |


  Scenario Outline: Test Login function for a locked-out user

    Given Open I launch chrome browser
    When I enter a valid "<Username>" and Valid "<Password>"
    Then The I click Login button
    And I verify that the "Sorry, this user has been locked out" message is displayed


    Examples:
      | Username      | Password     |
      | locked_out_user | secret_sauce |


  Scenario Outline: Test Login function for a Problem user

    Given Open I launch chrome browser
    When I enter a valid "<Username>" and Valid "<Password>"
    Then The I click Login button
    And I verify that the user is succefully logged in
    And I verify that the images are loaded


    Examples:
      | Username      | Password     |
      | locked_out_user | secret_sauce |

  Scenario Outline: Test Login function with a user prone to performance glitch

    Given Open I launch chrome browser
    When I enter a valid "<Username>" and Valid "<Password>"
    Then The I click Login button
    And I verify that the user is succefully logged in

    Examples:
      | Username                | Password     |
      | performance_glitch_user | secret_sauce |


  Scenario Outline: Test Login function with an invalid username

    Given Open I launch chrome browser
    When I enter a valid "<Username>" and Valid "<Password>"
    Then The I click Login button
    And I verify that an error message is displayedd

    Examples:
      | Username    | Password     |
      | InvalidUser | secret_sauce |