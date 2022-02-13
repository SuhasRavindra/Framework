package DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
@Test
public void verify() {
	String expProjectName = "Mercedes";
	Response response = when()
			.get("http://localhost:8084/projects");
			
			String actProjectName = response.jsonPath().getString("[0].projectName");
			
			response.then()
			   .assertThat()
			   .contentType(ContentType.JSON)
			   .log().all();
			   
			   Assert.assertEquals(expProjectName, actProjectName);
}
}
