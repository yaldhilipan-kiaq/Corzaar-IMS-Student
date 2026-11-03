@student
Feature: CORZAAR IMS Mobile Application

  Scenario Outline: Verify Continue with OTP with different Inputs
    Given Corzaar IMS  application is Launched
    When User taps the SignIn button
    And User enters mobile number "<mobilenumber>"
    And User clicks Continue with OTP button
    Then User should be on the "<expectedpage>"

    Examples:
      | mobilenumber | expectedpage           |
      # |              | remains on Student Login page |
      # | 12345        | remains on Student Login page |
      # | *****        | remains on Student Login page |
      # | *****+++++   | navigates  to OTP page        |
      # | 12345+++++   | navigates  to OTP page        |
      | 1234512345   | navigates  to OTP page |

  Scenario Outline: Verify OTP field with Different Inputs
    Given User is on the OTP Verification Page
    When User enters the OTP number "<otp>"
    And User clicks the Verify and Continue button
    Then User should be on  "<expectedPage>"

    Examples:
      | otp    | expectedPage           |
      # |        | remains on OTP page    |
      # | ,-.--, | remains on OTP page    |
      # | 123    | remains on OTP page    |
      | 123456 | Successfully Logged In |
