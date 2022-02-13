package PracticeCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Create {
	@Test
	public void create()  {
		
		Random ran = new Random();
		int randomNumber=ran.nextInt(500);
		
		//step 1=create test data
		JSONObject jobj=new JSONObject();
		jobj.put("CreatedBy", "Suhas");
		jobj.put("projectName", "Jaguar"+ randomNumber);
		jobj.put("Status", "Completed");
		jobj.put("teamSize", 420);
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
        .contentType(ContentType.JSON)
        .log().all();
	}
}
