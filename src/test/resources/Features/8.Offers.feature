Feature: CORZAAR IMS Mobile Application

  @offers
  Scenario: Verify Offers Count
    Given User verifies Live offers
    When User clicks the Offers module
    And User Verifies the Offers count
    Then User Navigate back
