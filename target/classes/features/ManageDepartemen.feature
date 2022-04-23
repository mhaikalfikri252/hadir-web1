Feature: User mengakses menu manage departemen

  Scenario: Testing menu departemen
    # Given User mengakses web
    # When User menampilkan manage departemen
    When User klik menu manage departemen
    And User tambah data departemen
    And User edit data departemen
    And User hapus data departemen
    Then User berhasil melakukan tambah data departemen edit data departemen and hapus data departemen
