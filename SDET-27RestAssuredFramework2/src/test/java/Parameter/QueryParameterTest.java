package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
	@Test
	public void Param() {   
		given()
		   .queryParam("page", "10")
		.when()
	       .get("http://reqres.in/api/users")
	    .then()
	   .assertThat().statusCode(200)
	   .log().all();
		
	}
		

}
