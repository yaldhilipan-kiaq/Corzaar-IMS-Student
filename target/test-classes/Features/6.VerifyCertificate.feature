Feature: CORZAAR IMS Mobile Application

  Scenario: Certificate verify module with Invalid ID
    Given User is on the Home page
    When User Clicks Verify Option to verify certificate
    And User enters  Certificate "<id>" ID
    And user Clicks the Verify certificate button
    And A Certificate is found
    Then user navigate backs to home page

  Examples:
|id|
|QQQQQ|
|CZ-CERT-372C1BBC|