Feature: CORZAAR IMS Mobile Application

@invalidcourse
  Scenario: Verify user can search valid course through Search Option
    Given User Clicks course option to search course
    When User enters Valid Course "Chemical Course " name
    And User Clicks the Search button for valid course
    Then Valid Course is displayed
@Validcourse
  Scenario: Verify user can search Invalid course through Search Option
    Given User enters InValid Course "Gaming" name
    When User apply the search to check the courses
    Then No  Course should be displayed

  Scenario: Verify User can add Course to Favourites
    Given User is on the Course page
    And User Click the Favourites button to add course
    Then The Course is added in favourites

@category
  Scenario: Verify User can search course by Category
    Given User clicks the Filter & Sort option to select category
    When User clicks Technology category
    And User clicks the Apply Filter button
    Then Courses are displayed for selected category

  Scenario: Verify User can search course by 1to3 months Duration
    Given User is on the courses page after selecting category
    When User clicks the Filter & Sort option for duration
    And User clicks 1to3 months
    And User clicks the Apply Filter
    Then Courses are displayed for selected duration

  Scenario: Verify User can search course by 3to6 months Duration
    Given User is on the courses page after selected duration
    When User clicks the Filter & Sort option for new duration
    And User clicks 3to6 months
    And User clicks the Apply Filter for duration
    Then Courses are displayed for newly selected duration

  Scenario: Verify User can search course by Free
    Given User is on the courses page after selecting Duration
    When User clicks the Filter & Sort option for free course
    And User clicks Free Course Only
    And User clicks the Apply Filter to select free course
    Then Courses are displayed

  Scenario: Verify User can search course by mode
    Given User is on the courses page after selecting free course
    When User clicks the Filter & Sort option to select mode
    And User clicks Online Course Only
    And User clicks the Apply Filter to select mode of the  course
    Then Courses are displayed for selected mode
