Feature: CORZAAR IMS Mobile Application

  Scenario: Verify Apply Coupon without SignIn
    Given User is on the Home Page after SignOut
    When User clicks Course module
    And User select a course to apply Coupon
    And User clicks Apply Coupon button
    And It remainds user needs to SignIn before apply Coupon
    Then User navigates back to Home Page

  Scenario: Verify Start Payment without Sign In
    Given User is on the Home Page
    When User Clicks Course module to Initiate Payment
    And User selects a course to Initiate payment
    And User Clicks Start Payment button
    And It remainds user needs to signIn before start a payment
    And User close the Student Sign In portal
    And  User navigates back 
    Then User is on the homepage and signin option is visible
