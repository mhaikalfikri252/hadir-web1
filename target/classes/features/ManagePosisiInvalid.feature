Feature: User Akses Manage Level

  Scenario: Testing Menu Manage Posisi Invalid
    When Admin tambah data posisi invalid
    And Admin ubah data posisi invalid
    Then Admin tidak berhasil tambah dan ubah data posisi