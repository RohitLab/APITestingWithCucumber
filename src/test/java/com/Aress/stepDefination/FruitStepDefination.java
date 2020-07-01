package com.Aress.stepDefination;



import static io.restassured.RestAssured.given;

import org.junit.Assert;

import com.Aress.PayLoad.TestPayLoad;
import com.Aress.resources.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class FruitStepDefination extends Utils {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	TestPayLoad TestPayLoad = new TestPayLoad();

	@Given("^Add Customer Payload with first name as : \"([^\"]*)\" and last name as: \"([^\"]*)\"$")
	public void add_Customer_Payload_with_first_name_as_and_last_name_as(String firstname, String lastname)
			throws Throwable {
		
		reqSpec = given().spec(requestSpecification()).body(TestPayLoad.setData(firstname, lastname));
		
	}

	@When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	public void user_calls_with_http_request(String arg1, String arg2) throws Throwable {

		
		com.Aress.resources.APIResources resourceAPI = com.Aress.resources.APIResources.valueOf(arg1);
		System.out.println(resourceAPI.getResource());

		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (arg2.equalsIgnoreCase("POST"))
			response = reqSpec.when().post(resourceAPI.getResource());
		else if (arg2.equalsIgnoreCase("GET"))
			response = reqSpec.when().get(resourceAPI.getResource());

		/*response = reqSpec.when().post("/shop/customers/").then().spec(resSpec).extract().response();*/

	}

	@Then("^the API call got success with status code (\\d+)$")
	public void the_API_call_got_success_with_status_code(int arg1) throws Throwable {

		Assert.assertEquals(201, response.getStatusCode());
	}

	@Then("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void in_response_body_is(String arg1, String arg2) throws Throwable {
		String jsonResponce = response.toString();
		JsonPath js = new JsonPath(jsonResponce);
		Assert.assertEquals(js.get(arg1).toString(), arg2);
	}

}
