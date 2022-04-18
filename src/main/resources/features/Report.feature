Feature: User melakukan export data karyawan

  Scenario: Testing halaman report
    Given User mengakses halaman web
    When User login ke halaman website
    And User klik menu report
    And User melakukan pencarian data
    And User melakukan export data
    Then User berhasil melakukan export data
