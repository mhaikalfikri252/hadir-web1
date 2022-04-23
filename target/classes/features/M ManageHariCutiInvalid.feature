Feature: User Akses Manage Hari Cuti Invalid

  Scenario: Testing Menu Manage Hari Cuti Invalid
    When User tambah data hari cuti invalid
    Then User tidak berhasil tambah data hari cuti
