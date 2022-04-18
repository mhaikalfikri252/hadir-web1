Feature: User cek to Dashboard

  Scenario: Testing View Dashboard Page
    Given User mengakses url web hadir
    When User login dan menampilkan dashboard
    And User klik card staff
    And User klik card leader
    And User klik card change request
    And User klik card supervisior
    And User klik card manager
    And User klik card head
    And User klik button See All
    Then User berhasil cek button in Dashboard
