package stepDefinitionFiles;

import dataFiles.ProjectDataClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyOrderApi {

    public VerifyOrderApi(ProjectDataClass dataProvider) {

    }
    @When("^user calls \"([^\"]*)\" with (.+) order token with get request$")
    public void user_calls_something_with_order_token_with_get_request(String ordertoken, String apiRes) throws Throwable {


    }
    @Then("^api call got success with status code 200$")
    public void api_call_got_success_with_status_code_200() {
    }
    @And("^responds payload contains correct status$")
    public void responds_payload_contains_correct_status() throws Throwable {

    }

    @And("^responds payload contains correct captureStatus$")
    public void responds_payload_contains_correct_capturestatus() throws Throwable {

    }

    @And("^responds payload contains correct currency$")
    public void responds_payload_contains_correct_currency() throws Throwable {

    }

    @And("^responds payload contains correct total amount$")
    public void responds_payload_contains_correct_total_amount() throws Throwable {

    }
}
