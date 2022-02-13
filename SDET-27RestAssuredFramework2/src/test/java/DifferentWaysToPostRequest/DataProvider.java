package DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProvider {
	@Test
	public void create(String createdBy, String projectName, String status, int teamSize)  {
		PojoClass pojo=new PojoClass(createdBy, projectName, status, teamSize);
      given()
        .body(pojo)
		.contentType(ContentType.JSON)
	.when()
    	.post("http://localhost:8084/addProject")
	.then()
	  .assertThat().statusCode(201)
	  .contentType(ContentType.JSON)
	  .log().all();
      }

	
	@DataProvider
	public Object[][] getData()  {
		Object[][] objArray=new Object[2][4];
		
		objArray[0][0]="Suhas";
		objArray[0][1]="Skoda";
     	objArray[0][2]="completed";
     	objArray[0][3]=50;
     	
     	objArray[1][0]="Shivanna";
		objArray[1][1]="Hyundai";
     	objArray[1][2]="completed";
     	objArray[1][3]=100;
     	
     	return objArray;
	}
}