@duplicateHyperLinks @bullsTest @Tests
Feature: Saving all the hyperlinks of the footer links into a CSV file and attaching int cucumber report and report if any duplicate hyperlinks are present

  Scenario: Saving all the hyperlinks of the footer links into a CSV file and report if any duplicate hyperlinks are present
    Given user is on bulls homepage "Data.BullsData.BullsUrl"
    When user scrolls down to footer section
    Then user finds all the hyperlinks available in the footer and saves into a "Data.BullsData.CsvFilePath" file
    And user verifies for any duplicate hyperlinks

