Feature: User Akses Manage Absen Point

  Scenario: Testing Menu Manage Absen Point
    Given User mengakses link web hadir
    When User akses login link web
    And User klik manage absen point
    And User tambah data absen point
    And User edit data absen point
    And User hapus data absen point
    Then User berhasil hapus data absen point
