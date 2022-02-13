package PracticeCRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetResources {
	@Test
	public void getResources()  {
		
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat().statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
