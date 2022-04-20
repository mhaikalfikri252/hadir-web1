Feature: User Akses Self Registration

  Scenario: Testing Menu Self Registration
    Given User akses url web hadir
    When User melakukan login di web hadir
    And User klik Self Registration
    Then Tampil halaman Self Registration
