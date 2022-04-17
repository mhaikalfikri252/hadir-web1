Feature: User Akses Manage Hari Cuti

  Scenario: Testing Menu Manage Hari Cuti
    Given User mengakses web hadir1
    When User akses login web
    And User klik manage hari cuti
    And User tambah data hari cuti
    And User edit data hari cuti
    And User hapus data hari cuti
    Then User berhasil hapus data hari cuti
