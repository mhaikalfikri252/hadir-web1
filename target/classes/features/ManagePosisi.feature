Feature: Admin Tambah Manage Level

  Scenario: Testing halaman Manage Posisi
    Given User masuk situs hadir
    When Admin login ke halaman web
    And Admin klik menu manage posisi
    And Admin klik tambah posisi
    And Admin klik ubah posisi
    And Admin klik hapus posisi
    Then Admin success go to tambah posisi and ubah posisi and hapus posisi
