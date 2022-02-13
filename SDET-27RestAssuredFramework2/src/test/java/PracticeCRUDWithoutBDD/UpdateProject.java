package PracticeCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProject()  {
		
		//step 1 
		JSONObject jobj=new JSONObject();
		jobj.put("CreatedBy", "Suhas");
		jobj.put("ProjectId","TY_PROJ_002");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 25);
		
		//step 2
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jobj);
		
		//step 3 
		Response resp = req.put("http://localhost:8084/projects/TY_PROJ_002");
		
		//step 4 
		ValidatableResponse Validate = resp.then();
		Validate.assertThat().statusCode(200);
		Validate.log().all();
	}

}