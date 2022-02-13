package PracticeCRUDWithoutBDD;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteProject {
	@Test
	public void deleteProject()  {
		int expstatus = 204;
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_203");

		//step 2 
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println(resp.prettyPrint());
	}
}