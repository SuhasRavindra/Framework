package DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class DynamicResponseValidation2 {
	@Test
	public void verify()  {
		String expProjectName = "Mercedes";
		Response response = when()
				.get("http://localhost:8084/projects");
		
		List<String> proNames = response.jsonPath().get("projectName");
	boolean flag=false;
	for(String pNames:proNames)  {
		
		if(pName.equals(expProjectName))  {
			flag=true;
		}
		
		response.then()
		   .assertThat()
		   .contentType(ContentType.JSON)
		   .log().all();
		   
		   Assert.assertEquals(flag, true);
		
		
	}
	
	}

}
