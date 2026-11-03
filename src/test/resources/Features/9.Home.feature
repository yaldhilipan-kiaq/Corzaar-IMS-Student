Feature: CORZAAR IMS Mobile Application

Scenario: Search  Course from the Home page by Category
Given User is on the home page
When  User selects "<category>" category
And User taps the search courses button
Then The courses are displayed for the selected Category

Examples:
|category|
|Technology|



