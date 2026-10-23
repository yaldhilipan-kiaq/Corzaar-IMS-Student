Feature: CORZAAR IMS Mobile Application

  @Login
  Scenario Outline: Verify Continue with OTP with different Inputs
    Given Corzaar IMS  application is Launched
    When User taps the SignIn button
    And User enters mobile number "<mobile number>"
    And User clicks Continue with OTP button
    Then User should be on the "<expected page>"

    Examples:
      | mobile number | expected page          |
      # |               | remains on Student Login page |
      # | 12345         | remains on Student Login page |
      # | *****         | remains on Student Login page |
      # | *****+++++    | navigates  to OTP page        |
      # | 12345+++++    | navigates  to OTP page        |
      | 1234512345    | navigates  to OTP page |

  @otp
  Scenario Outline: Verify OTP field with Different Inputs
    Given User is on the OTP Verification Page
    When User enters the OTP number "<otp>"
    And User clicks the Verify and Continue button
    Then User should be on  "<expected page>"

    Examples:
      | otp    | expected page          |
      # |        | remains on OTP page    |
      # | ,-.--, | remains on OTP page    |
      # | 123    | remains on OTP page    |
      | 123456 | Successfully Logged In |
# Scenario: Verify Continue with OTP with Invalid mobile number
# Given Corzaar application is launched
# When User taps SignIn button
# And User enters  invalid mobile number
# And User clicks the continue with otp button
# Then User should remain on the student login page
# Scenario: Verify Continue with OTP with valid mobile number
# Given User is on the Student login page
# When User enters  valid mobile number
# And User clicks the continue with otp button to generate otp
# Then User should naviagtes to otp verification page
# Scenario: Verify Student Login with Invalid OTP
# Given User is on the OTP Verification Page
# When User enters  Invalid OTP number
# And User clicks the Verify and Continu button
# Then User should Remain on the Otp Verification page
# Scenario: Verify Student Login with valid OTP
# Given User is on the OTP Verification Page after entering invalid otp
# When User enters  valid OTP number
# And User clicks the Verify and Continu button for successful login
# Then User should Logged in Successfully
