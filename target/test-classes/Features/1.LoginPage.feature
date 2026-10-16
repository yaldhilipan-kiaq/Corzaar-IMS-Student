Feature: CORZAAR IMS Mobile Application

  Scenario: Verify Continue with OTP with Invalid mobile number
    Given Corzaar application is launched
    When User taps SignIn button
    And  User enters  invalid mobile number 
    And User clicks the continue with otp button
    Then User should remain on the student login page
    
      Scenario: Verify Continue with OTP with valid mobile number
    Given User is on the Student login page
    When User enters  valid mobile number
    And User clicks the continue with otp button to generate otp
    Then User should naviagtes to otp verification page
    
  Scenario: Verify Student Login with Invalid OTP
    Given User is on the OTP Verification Page
    When User enters  Invalid OTP number
    And User clicks the Verify and Continu button 
    Then User should Remain on the Otp Verification page
 
Scenario: Verify Student Login with valid OTP
    Given User is on the OTP Verification Page after entering invalid otp
    When User enters  valid OTP number
    And User clicks the Verify and Continu button for successful login
    Then User should Logged in Successfully
 