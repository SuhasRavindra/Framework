package PracticeCRUDWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
	@Test
	public void updateProject() {
	
	
	Random ran = new Random();
	int randomNumber=ran.nextInt(500);
	
	
	JSONObject jobj=new JSONObject();
	jobj.put("CreatedBy", "Shivu");
	jobj.put("ProjectName","TestYntra" + randomNumber);
	jobj.put("status", "Completed");
	jobj.put("teamSize", 50);
	
	given()
	.body(jobj)
	.contentType(ContentType.JSON)
	
	.when()
	.put("http://localhost:8084/Projects/TY_PROJ_004")
	
	.then()
	  .assertThat().contentType(ContentType.JSON)
	  .statusCode(200)
	  .log().all();
}

}
