Feature: Customer Login to Hadir

  Scenario: Testing Login Customer Valid
    Given Customer mengakses url
    When Customer klik login button
    Then Customer berhasil login

  Scenario: Testing Login Customer Invalid
    When Customer klik logout button
    And Cutomer klik login button
    Then Customer tidak berhasil login
