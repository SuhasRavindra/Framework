package Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {
	@Test
	public void param() {
	
		given()
		.pathParam("projectId", "TY_PROJ_003")
		.when()
		   .delete("http://localhost:8084/projects/{projectId}")
		 .then()
		   .log().all();
		
	}

}
