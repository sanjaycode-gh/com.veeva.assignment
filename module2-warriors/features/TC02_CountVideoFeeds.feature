@warriorsTest @warriorsCountFeeds @Tests
Feature: Count total number of video feeds in the warriors news and features menu

  Scenario: Count total number of video feeds
    Given user is on warriors Homepage "Data.WarriorsData.WarriorsUrl"
    When user navigates to "Data.WarriorsData.NewsMenu" menu
    Then user verifies it should be on "Data.WarriorsData.NewsHeader" page
    And user counts total number of "Data.WarriorsData.FeedType" feeds
    And user counts total number of "Data.WarriorsData.FeedType" feeds present in page >= "Data.WarriorsData.Time"