Feature: Purchase

  Scenario: Purchase of Hummingbird Printed Sweater

    Given User  logs in to his account
    When User type Hummingbird Printed Sweater in the search field
    And User choose Hummingbird Printed Sweater
    And User selects size M
    And User selects the number of pieces 5
    And User adds the product to the basket
    And User goes to the checkout option
    And User confirms the address
    And User selects the PrestaShop collection method from the shipping method option
    And User goes to the payment option
    And User chooses the Pay by Check pickup method
    And User accepts the regulations
    And User approves the order
    Then User takes a screenshot with the order confirmation and the amount
