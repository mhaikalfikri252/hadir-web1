Feature: User Access Manage Level Invalid

  Scenario: Testing Menu Manage Level Invalid
    When User tambah data level invalid
    And User edit data level invalid
    Then User tidak berhasil tambah dan hapus data level