Feature: Customer klik Staff

  Scenario: Testing Staff Page
    Given Admin akses url
    When Admin akses login
    And Admin klik staff page
    And Admin search data by NIK
    Then Tampil data berdasarkan NIK
    When Admin search data by invalid NIK
    Then Tampil error data NIK tidak ditemukan
    When Admin search data by name
    Then Tampil data berdasarkan name
    When Admin search data by invalid name
    Then Tampil error data name tidak ditemukan
    When Admin search data by divisi
    Then Tampil data berdasarkan divisi
    When Admin search data by invalid divisi
    Then Tampil error data divisi tidak ditemukan
    When Admin klik view history staff
    Then Tampil halaman History Staff
    When Admin eksport data history staff
    When Admin edit data staff
    Then Admin success go to view history staff page and edit data
