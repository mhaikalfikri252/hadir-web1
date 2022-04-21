Feature: User Akses Form Register

  Scenario: Testing Menu Form Registration
    Given Admin akses url web hadir
    When Admin akses loginn
    And User klik Form Registration
    Then Tampil halaman Form Registration
    When Masukkan form Registrasi
    Then Data berhasil di upload
