package PracticeCRUDWithoutBDD;


	import org.json.simple.JSONObject;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class CreateProject 
	{
		@Test
		public void CreateProject()
		{

			//step 1- create test data
			JSONObject jobj=new JSONObject();
			jobj.put("CreatedBy", "Suhas");
			jobj.put("ProjectId","TY_PROJ_002");
			jobj.put("status", "Created");
			jobj.put("teamSize", 10);

			//step 2- Provide request specification
			RequestSpecification req = RestAssured.given();
			req.contentType(ContentType.JSON);
			req.body(jobj);

			//step 3- perform the action
			Response resp = req.post("http://localhost:8084/addProject");

			//print in console and verify
			System.out.println(resp.asString());
			System.out.println(resp.prettyPrint());
			System.out.println(resp.prettyPeek());
			System.out.println(resp.getContentType());
		}
	}
