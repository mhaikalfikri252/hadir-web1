Feature: User akses manage setting

  Scenario: Testing menu manage setting
    Given User akses url
    When User klik menu setting
    And User klik menu ubah data
    And User klik tombol switch liveness
    Then User success go to manage setting and edit data validation timer
