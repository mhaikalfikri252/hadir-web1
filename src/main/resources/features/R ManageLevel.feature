Feature: User Access Manage Level Page

  Scenario: Testing halaman Manage Level
    # Given User masuk situs hadir Web 1
    # When Admin login ke halaman web1
    When Admin klik menu manage level
    And Admin klik tambah level
    And Admin klik ubah level
    And Admin klik hapus level
    Then Admin success go to tambah level and ubah level and hapus level
