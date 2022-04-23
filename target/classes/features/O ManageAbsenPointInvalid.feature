Feature: User Access Manage Absen Point Invalid

  Scenario: Testing Menu Manage Absen Point Invalid
    When User tambah data absen point invalid
    And User edit data absen point invalid
    Then User tidak berhasil tambah dan edit data absen point
