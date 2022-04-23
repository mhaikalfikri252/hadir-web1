Feature: User Access Manage Departemen Invalid Page

  Scenario: Testing Menu Manage Departemen Invalid
    When User tambah data departemen invalid
    And User edit data departemen invalid
    Then User tidak berhasil tambah dan edit data departemen