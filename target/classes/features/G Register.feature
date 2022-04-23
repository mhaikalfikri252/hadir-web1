Feature: User Access Register Page

  Scenario: Testing halaman register
    # Given User mengakses url web
    # When User login ke halaman web
    When User klik menu register
    And User melakukan pencarian data karyawan
    And User melakukan perubahan data
    Then User berhasil melakukan perubahan data
