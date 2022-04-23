Feature: User Access Self Registration Page

  Scenario: Testing Menu Self Registration
    # Given User akses url web hadir
    # When User melakukan login di web hadir
    When User klik Self Registration
    And Klik edit data
    And edit data staff
    Then Data berhasil Diedit
    When Reject data karyawan
    Then Data berhasil di reject
