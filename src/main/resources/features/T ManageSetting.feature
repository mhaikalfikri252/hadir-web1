Feature: User akses manage setting

  Scenario: Testing menu manage setting
    # Given User akses url web
    # When User melakukan validasi login web hadir
    When User klik menu manage setting
    And User klik ubah data
    And User klik switch liveness
    Then User success go to manage setting and edit data validation timer
