@student
Feature: CORZAAR IMS Mobile Application

  Scenario: Verify Institue module from the home page
    Given User is on home page to view the institutes
    When User Clicks the Institute module to view all the institutes
    And User should navigate to Institute page
    Then User navigate back to homepage
