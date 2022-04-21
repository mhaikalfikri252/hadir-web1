Feature: User Akses Form Register

  Scenario: Testing Menu Form Registration
    Given Admin akses url web hadir
    When Admin akses loginn
    And User klik Form Registration
    Then Tampil halaman Form Registration
    When Masukkan invalid foto
    Then Tampil pesan error
    When Masukkan valid foto
    Then Tampil pesan wajah terdeteksi
    When Masukkan valid form
    Then Data berhasil di upload
