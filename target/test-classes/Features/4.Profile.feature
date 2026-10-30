Feature: CORZAAR IMS Mobile Application

  @profile
  Scenario: verify Profile Completion with empty fields
    Given User verifies the Profile name
    When User enters "<name>" in profile name field
    And User enters "<email>" in profile email field
    And User Clicks Save profile button
    Then The profile name is changed as "<expected>"

    Examples:
      | name        | email                | expected |
      | NEW STUDENT | newstudent@gmail.com | Valid    |

  Scenario: Verify Referral Code
    Given User clicks Referal option
    When User verifies the Referral code
    And user clicks back button
    Then User navigates back to profile

  Scenario: Verify Course Completion by Mark Curriculumn
    Given User click Profile option
    When User Clicks Mark Curriculumn Progress
    And User Clicks Customer Journey to complete the progress
    And User Clicks content system to complete the progress
    And User Clicks growth experiment to complete the progress
    And User verifys the course is completed
    And User Verifies view Certificate
    And user verfiies Download pdf
    And User clicks request refund button
    And User enters the reason for the refund
    And User enters the submit button
    Then User clicks sign out button
