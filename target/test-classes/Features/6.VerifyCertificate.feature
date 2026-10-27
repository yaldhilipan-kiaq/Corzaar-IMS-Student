Feature: CORZAAR IMS Mobile Application

  Scenario: Certificate verify module with Invalid ID
    Given User is on the Home page
    When User Clicks Verify Option to verify certificate
    And User enters Invalid Certificate "QQQQQ" ID
    And user Clicks the Verify certificate button
    Then An Error message should be displayed for invalid certificate ID

  Scenario: Certificate verify module with valid ID
    Given User enters valid Certificate "CZ-CERT-22B0538E" ID
    When User Clicks the verify certificate button for valid ID
    And A valid Certificate is found
    Then user navigate backs to home page

 
