Feature: New address

  Scenario Outline: New address for the user

    Given User is on the My story page
    When User is going to change address page
    And a keyword <PioTes> is entered in input alias field
    And a keyword <Piotr> is entered in input First name field
    And a keyword <Tester> is entered in input Last name field
    And a keyword <Testics> is entered in input Company field
    And a keyword <123456> is entered in input Vat number field
    And a keyword <Polna> is entered in input Address field
    And a keyword <10> is entered in input Address Complement field
    And a keyword <Warszawa> is entered in input City field
    And a keyword <41-100> is entered in Postal Code field
    And a keyword United Kingdom is selected
    And a keyword <777777777> is entered in input Phone field
    And the save button is selected
    And the address changed and checked
    Then browser closed


    Examples:
      | PioTes| Piotr | Tester | Testics | 123456 | Polna | 10 | Warszawa | 41-100 | 777777777 |
      | PioTes | Piotr | Tester | Testics | 123456 | Polna | 10 | Warszawa | 41-100 | 777777777 |
      ##| PioTes | Piotr| Tester | Testics | 123456 | Wodna | 10 | Warszawa | 41-100 | 777777777 |
