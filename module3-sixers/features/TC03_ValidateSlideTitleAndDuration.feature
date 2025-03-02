@sixersTest @verifySlidesTitle @Tests
Feature: Validation of title and duration of the each slide playing in the sixers homepage

  Scenario: Validation of title and duration of the each slide playing in the sixers homepage
    Given user is on sixers homepage "Data.SixersData.SixersUrl"
    Then user counts number of slides present
    And user verifies title of each slide with expected title
    |Data.SixersData.Slide1|
    |Data.SixersData.Slide2|
    |Data.SixersData.Slide3|
    |Data.SixersData.Slide4|
    |Data.SixersData.Slide5|
    And user verifies the duration of each slide with expected duration
    |Data.SixersData.Duration|
