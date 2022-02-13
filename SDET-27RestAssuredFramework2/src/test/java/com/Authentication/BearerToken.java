package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken() {
		given()
		    .auth().oauth2("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")
		.when()
		    .get("https://github.com/settings/tokens")
		.then()
		    .assertThat().statusCode(200)
		    .log().all();
	}
	
	}


