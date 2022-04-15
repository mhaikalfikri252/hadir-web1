Feature: User mengakses halaman Register

  Scenario: Testing halaman register
    Given User mengakses url web
    When User login ke halaman web
    And User klik menu register
    And User melakukan pencarian data karyawan
    And User melakukan perubahan data
    Then User berhasil melakukan perubahan data