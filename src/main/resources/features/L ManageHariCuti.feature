Feature: User Access Manage Hari Cuti Page

  Scenario: Testing Menu Manage Hari Cuti
    # Given User mengakses web hadir1
    # When User akses login web
    When User klik manage hari cuti
    And User tambah data hari cuti
    And User edit data hari cuti
    And User search data hari cuti
    And User hapus data hari cuti
    Then User berhasil hapus data hari cuti
