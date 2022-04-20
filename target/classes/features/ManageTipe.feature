Feature: User Akses Manage Tipe

  Scenario: Testing Menu Manage Tipe
    Given User mengakses web hadir
    When User akses login
    And User klik manage tipe
    And User tambah data tipe
    And User edit data tipe
    And User search data tipe
    And User hapus data tipe
    Then User berhasil hapus data
