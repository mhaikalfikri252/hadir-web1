Feature: User Access Manage Tipe Invalid Page

  Scenario: Testing Menu Manage Tipe Invalid
    When User tambah data tipe invalid
    And User edit data tipe invalid
    Then User tidak berhasil tambah dan edit data tipe
