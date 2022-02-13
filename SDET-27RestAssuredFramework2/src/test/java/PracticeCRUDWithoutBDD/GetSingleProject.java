package PracticeCRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	@Test
	public void getSingleProject()  {

		//Step 1- 
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_002");

		//Step 2 
		System.out.println(resp.prettyPeek());

	}
}
