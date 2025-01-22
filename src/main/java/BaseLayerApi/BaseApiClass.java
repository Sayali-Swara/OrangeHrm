package BaseLayerApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseApiClass {
	protected static RequestSpecification httpRequest;

	public static void reqSpecific() {
		// get Request Specification object
		httpRequest = RestAssured.given();

		// add content type header
		httpRequest.contentType(ContentType.JSON);

		// generate request logs
		httpRequest.log().all();

	}
	
}
