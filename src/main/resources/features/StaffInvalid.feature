Feature: User Akses Staff

  Scenario: Testing Menu Staff Invalid
    When Admin Klik Halaman Staff
    And Admin search data staff invalid
    And Admin edit data staff invalid
    Then Admin tidak berhasil tambah dan ubah data staff
