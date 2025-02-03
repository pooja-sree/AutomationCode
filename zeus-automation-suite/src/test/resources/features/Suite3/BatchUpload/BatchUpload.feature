Feature: Batch Upload
  This feature file validates the Batch upload of events.

  @RegressionTest @Sanity @Smoke
  Scenario: 01 Create 4 TD Events--using Batch Upload spreadsheets.
    Given Create Events Batch Upload - TD2 - TD-EP-BatchUploadSample.csv

  @RegressionTest
  Scenario: 02 Create 4 CC Events--using Batch Upload spreadsheets.
    Given Create Events Batch Upload - CC1 - CC-BatchUploadSample.csv

  @RegressionTest
  Scenario: 03 Create 4 SC Events--using Batch Upload spreadsheets.
    Given Create Events Batch Upload - SP2 - SC-BatchUploadSample.csv


