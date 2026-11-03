@student
Feature: CORZAAR IMS Mobile Application

  
  Scenario: Verify Offers Count from the home page
    Given User verifies Live offers displayed
    When User clicks the Offers module to copy the offers
    And User Verifies the Offers count that are present
    Then User Navigate back to the homepage
