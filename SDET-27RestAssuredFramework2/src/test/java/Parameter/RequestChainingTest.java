package Parameter;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {
	@Test
	public void chaining()  {
		Response response = when()
				.get("//http:localhost:8084/projects");
		String proID = response.jsonPath().get("[0].Status");
		System.out.println(proID);

		given()
		.pathParam("projectId", "proID")
		.when()
		.get("http//localhost:8084/projects/{projectId}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}
