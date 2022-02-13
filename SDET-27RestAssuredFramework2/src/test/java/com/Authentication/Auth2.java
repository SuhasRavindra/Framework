package com.Authentication;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth2 {


@Test
public void auth() {
	
	 Response response = given()
	   .formParams("client_id", "Optimizer")
       .formParams("client_secret", "919eda1d4e964dde5cee51c4dde77271")
	   .formParams("grant_type", "client_credentials")
	   .formParams("redirect_uri", "https://example.com")
	.when()
	   .post("http://coop.apps.symfonycasts.com/token");
	    String token=response.jsonPath().get("access_token");	
	
	given()
       .auth().oauth2(token)
       .pathParam("USER_ID", "2798")
    .when()   
       .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
    .then()
       .log().all();
}
}
