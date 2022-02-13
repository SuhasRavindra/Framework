package PracticeCRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteTheResources {
	@Test
	public void deleteResources() {
		
		when()
		 .delete("http://localhost:8084/Projects/TY_PROJ_005")
		
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}

}
