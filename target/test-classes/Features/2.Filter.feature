Feature: CORZAAR IMS Mobile Application

  @searchcourse
  Scenario: Verify user can search valid course through Search Option
    Given User Clicks course option to search course
    When User enters  Course "<courseName>" name
    And User Clicks the Search button for valid course
    Then Search Result should be "<result>"

    Examples:
      | courseName                | result    |
      | UI UX Design Fundamentals | displayed |

  Scenario: Verify User can add Course to Favourites
    Given User is on the Course page
    And User Click the Favourites button to add course
    Then The Course is added in favourites

  @category
  Scenario: Verify User can search course by Category
    Given User clicks the Filter & Sort option to select category
    When User clicks "<category>" category
    And User clicks the Apply Filter button
    Then Courses are displayed for selected category

    Examples:
      | category   |
      | Technology |

  Scenario: Verify User can search course by Duration
    Given User is on the courses page after selecting category
    When User clicks the Filter & Sort option for duration
    And User clicks "<months>"month
    And User clicks the Apply Filter
    Then Courses are displayed for selected duration

    Examples:
      | months      |
      | 1 -3 months |

  Scenario: Verify User can search course by Free
    Given User is on the courses page after selecting Duration
    When User clicks the Filter & Sort option for free course
    And User clicks Free Course Only
    And User clicks the Apply Filter to select free course
    Then Courses are displayed


@rating
  Scenario: Verify User can search course by rating
    Given User is on the courses page after selecting free course
    When User clicks the Filter & Sort option to select course by rating
    And User clicks "<rating>" for the Course 
    And User clicks the Apply Filter to filter the course
    Then Courses are displayed for selected rating

    Examples:
      | rating   |
      | Any |
  @mode
  Scenario: Verify User can search course by mode
    Given User is on the courses page after selecting the rating
    When User clicks the Filter & Sort option to select mode
    And User clicks "<mode>" Course Only
    And User clicks the Apply Filter to select mode of the  course
    Then Courses are displayed for selected mode

    Examples:
      | mode   |
      | Online |

  @sortby
  Scenario: Verify User can sort course by using filters
    Given User is on the courses page after selecting mode
    When User clicks the Filter & Sort option to sort
    And User clicks "<sort>" Course
    And User clicks the Apply Filter to sort the  course
    Then Courses are displayed for applied filter

    Examples:
      | sort    |
      | Price ↑ |
