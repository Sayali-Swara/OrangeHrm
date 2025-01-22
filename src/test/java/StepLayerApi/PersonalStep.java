package StepLayerApi;

import java.io.IOException;

import org.hamcrest.Matchers;



import BaseLayerApi.BaseApiClass;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class PersonalStep extends BaseApiClass

{
String PersonalCustomerRequestPayload;
Response response;
ValidatableResponse validateResponse;


@Given("user set base uri")
public void user_set_base_uri() {
RestAssured.baseURI= "http://localhost:1345/";
}

@Given("user set {string} base path")
public void user_set_base_path(String string) {
RestAssured.basePath = "personal";   
}

@Given("user get the request specification object")
public void user_get_the_request_specification_object() {
BaseApiClass.reqSpecific();    
}

@Given("user add personal employee id {string} as path parameter")
public void user_add_personal_employee_id_as_path_parameter(String pId) {
httpRequest.pathParam("pId", pId);    
}

@When("user select http get request to retrieve employee single entity")
public void user_select_http_get_request_to_retrieve_employee_single_entity() {
response = httpRequest.get("{id}");    
}

@Then("user get validatable reponse interface object")
public void user_get_validatable_reponse_interface_object() {
validateResponse = response.then().assertThat();    
}

@Then("user validate status code {int}")
public void user_validate_status_code(Integer code) {
validateResponse.statusCode(Matchers.equalTo(code));    
}

@Then("user validate status line {string}")
public void user_validate_status_line(String statusline) {
validateResponse.statusLine(Matchers.containsString(statusline));   
}

@Then("user validate response time {int} ms")
public void user_validate_response_time_ms(Integer time) {
validateResponse.time(Matchers.lessThan((long) time));   
}

@Then("user generate response logs")
public void user_generate_response_logs() {
validateResponse.log().all();   
}

@Given("user get request specification interface object")
public void user_get_request_specification_interface_object() {
BaseApiClass.reqSpecific();    
}

@Given("user create request payload for post request")
public void user_create_request_payload_for_post_request() throws IOException {

	PersonalCustomer pcustomer =new PersonalCustomer();
	pcustomer.setFullName("Sayali Shetteppa");
	pcustomer.setEmail("sayali@gmail.com");
	pcustomer.setPhone("3467465");
	pcustomer.setGender(false);
	pcustomer.setProduct_price(909.24f);
	pcustomer.setCity("Pune");
	pcustomer.setPincode(411012);
	pcustomer.setState("MH");
	pcustomer.setCountry("India");

	ObjectMapper mapper =new ObjectMapper();
	PersonalCustomerRequestPayload = mapper.writeValueAsString(pcustomer);
    
}

@Given("user add personal customer request payload to http requests")
public void user_add_personal_customer_request_payload_to_http_requests() {
httpRequest.body(PersonalCustomerRequestPayload);  
    
}

@When("user select http post request")
public void user_select_http_post_request() 
{
response = httpRequest.post();
    
}

@Then("user get Validatable response interface object")
public void user_get_validatable_response_interface_object()
{
validateResponse = response.then().assertThat();
}   
    

@Then("user validate status code {int}")
public void user_validate_status_code1(Integer statuscode)
{
validateResponse.statusCode(Matchers.equalTo(statuscode));
}
	
@Then("user validate status line {string}")
public void user_validate_status_line1(String statusline)
{
validateResponse.statusLine(Matchers.containsString(statusline));
}

@Then("user validate response time below {int} ms")
public void user_validate_response_time_below_ms(Integer time)
{
validateResponse.time(Matchers.lessThan((long)time));
}

@Then("user validate response {string} and {string} header")
public void user_validate_response_and_header(String keyName, String value) 
{
validateResponse.header(keyName, Matchers.containsString(value));   
}

@Given("user add personal employee firstname {string} as path parameter")
public void user_add_personal_employee_firstname_as_path_parameter(String firstname) 
{
httpRequest.pathParam("firstname", firstname);  
}

@Given("user add employee query parameter {string} and {string}")
public void user_add_employee_query_parameter_and(String keyName, String value)
{
httpRequest.queryParam(keyName, value);    
}

@When("user select http delete request to delete personal employee single entity")
public void user_select_http_delete_request_to_delete_personal_employee_single_entity() {
response = httpRequest.delete("{id}");
    
}

@When("user select http get request to retrieve all personal employee entity")
public void user_select_http_get_request_to_retrieve_all_personal_employee_entity() 
{
response = httpRequest.get();     
}


}