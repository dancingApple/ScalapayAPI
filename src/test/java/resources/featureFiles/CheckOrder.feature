Feature: Check Order

  Scenario Outline: Verify order details
    Given user hit the scalaPay api
    When user calls "getOrderApi" with <orderToken> order token with "get" request
    Then api call got success with status code 200
    And order status in responds is "charged"
    And order captureStatus in responds is "captured"
    And order currency in responds is "EUR"
    And responds payload contains correct total amount
    @test
    Examples:
      | orderToken |
      | A1KQ7URT63 |