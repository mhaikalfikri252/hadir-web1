Feature: Admin click Manage Shift Page

  Scenario: Testing Manage Shift Page
    Given Akses url oleh admin
    When Admin mengakses login
    And Admin klik Manage Shift page
    And Admin add shift time
    And Admin Search By Shift Code
    And Admin edit shift time
    Then Admin success go to add shift page and edit data
