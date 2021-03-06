package PracticeCRUDWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateResorcesUsingJsonFile {
	@Test
	public void createUsingJson() {
		
		File file = new File("./createData.Json");
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost/8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
