Feature: CORZAAR IMS Mobile Application

  Scenario: verify Profile Completion with empty fields
    Given User verifies the Profile name before completion
    When user leaves the profile name empty
    And user leaves the profile email empty
    And User clicks the save profile
    Then Complete your profile is displayed

  Scenario: Verify Profile Completion
    Given User enters "NEW STUDENT" in profile name field
    When User enters "newstudent@gmail.com" in profile email field
    And User Clicks Save profile button
    Then The profile name is changed successfully

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
    Then User clicks sign out button
