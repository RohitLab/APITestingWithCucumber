Feature: place Validation 

Scenario: Verify if Customer is being Succesfully create in Fruit API
	Given Add Customer Payload with first name as : "Pit" and last name as: "Bull"
	When user calls "CreateCustomerAPI" with "POST" http request
	Then the API call got success with status code 201
	And "lastname" in response body is "Bull"