package stepDefinition;

import ApiResource.OrderResource;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import operation.OrderCalculation;
import pojo.GetOrder;
import util.CommonMeth;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class VerifyOrderApi extends CommonMeth {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    GetOrder order;

    @Given("^user hit the scalaPay api$")
    public void user_hit_the_scalapay_api() throws Throwable {
        res=given().spec(requestSpecification());
    }

    @When("^user calls \"([^\"]*)\" with (.+) order token with \"([^\"]*)\" request$")
    public void user_calls_something_with_order_token_with_request(String apiRes, String ordertoken, String method) throws Throwable {
        OrderResource resourceAPI=OrderResource.valueOf(apiRes);
        System.out.println(resourceAPI.getResource());

        resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if(method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource()+ordertoken);
        order = response.as(GetOrder.class);

    }
    @Then("^api call got success with status code 200$")
    public void api_call_got_success_with_status_code_200() {
        assertEquals(response.getStatusCode(),200);

    }
    @And("^order status in responds is \"([^\"]*)\"$")
    public void order_status_in_responds_is_something(String expectedStatus) throws Throwable {
        System.out.println("The status of the order: " + order.getStatus());
        assertEquals("The order status is not correct.",expectedStatus,order.getStatus());
    }

    @And("^order captureStatus in responds is \"([^\"]*)\"$")
    public void order_capturestatus_in_responds_is_something(String expectedCaptureStatus) throws Throwable {
        System.out.println("The capture status of the order: " + order.getCaptureStatus());
        assertEquals("The order status is not correct.",expectedCaptureStatus,order.getCaptureStatus());
    }

    @And("^order currency in responds is \"([^\"]*)\"$")
    public void order_currency_in_responds_is_something(String expectedCurrency) throws Throwable {
        System.out.println("The status of the order: " + order.getTotalAmount().getCurrency());
        assertEquals("The order status is not correct",expectedCurrency,order.getTotalAmount().getCurrency());
    }

    @And("^responds payload contains correct total amount$")
    public void responds_payload_contains_correct_total_amount() throws Throwable {
        float expectedTot = OrderCalculation.calculateTotal(order);
        float actualTot = order.getTotalAmount().getAmount();
        System.out.println("The expected order amount: " + expectedTot);
        System.out.println("The actual order amount: " + actualTot);
        assertEquals("Order total amount is not calculated correctly",expectedTot
                ,actualTot,0.00001);
    }
}
