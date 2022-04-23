Feature: User Access Staff Page

  Scenario: Testing Staff Page
    # Given Admin akses url
    # When Admin akses login
    When Admin klik staff page
    And Admin klik view history staff
    And Admin klik edit data staff
    Then Admin success go to view history staff page and edit data
