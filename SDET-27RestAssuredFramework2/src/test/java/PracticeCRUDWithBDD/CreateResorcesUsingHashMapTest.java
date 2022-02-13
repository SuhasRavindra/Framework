package PracticeCRUDWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateResorcesUsingHashMapTest {
	@Test
	public void create() {
		
		HashMap map = new HashMap();
		
		map.put("CreatedBy", "Suhas");
		map.put("projectName", "Toyota");
		map.put("Status", "Completed");
		map.put("teamSize", 100);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
