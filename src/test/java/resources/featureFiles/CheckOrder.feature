Feature: Check Order

  Scenario Outline: Verify order details
    Given user have the secret Key
    When user calls "getOrderApi" with <orderToken> order token with get request
    Then api call got success with status code 200
    And responds payload contains correct status
    And responds payload contains correct captureStatus
    And responds payload contains correct currency
    And responds payload contains correct total amount
    @test
    Examples:
      | orderToken |
      | A1KQ7URT63 |