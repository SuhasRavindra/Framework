package PracticeCRUDWithoutBDD;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAllProjects 
{
	@Test
	public void getAllProjects() {

		//step 1 - 
		int expstatus = 200;
		Response resp = RestAssured.get("http://localhost:8084");

		//step 2
		System.out.println(resp.prettyPeek());
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
	}
}

