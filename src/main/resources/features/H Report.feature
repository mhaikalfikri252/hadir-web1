Feature: User Access Report Page

  Scenario: Testing halaman report
    # Given User mengakses halaman web
    # When User login ke halaman website
    When User klik menu report
    And User melakukan pencarian data
    And User melakukan export data
    Then User berhasil melakukan export data
