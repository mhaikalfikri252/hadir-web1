Feature: Customer klik Staff

  Scenario: Testing view history Staff Page
    When Admin klik staff page
    And Admin klik view history staff
    And Admin klik edit data staff
    Then Admin success go to view history staff page and edit data
