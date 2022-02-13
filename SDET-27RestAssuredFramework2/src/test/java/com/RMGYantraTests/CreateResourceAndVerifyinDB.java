package com.RMGYantraTests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPoints;
import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import sun.rmi.transport.Endpoint;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

public class CreateResourceAndVerifyinDB extends BaseAPIClass {
	@Test
	public void createResourceInDB() throws SQLException {

		//step 1 - create the test data
		PojoClass pLib = new PojoClass("Suhas", "LandRover"+jLib.RandomNumber(), "Completed", 40);

		//execute post request
		Response resp = given()
				.body(pLib)
				.contentType(ContentType.JSON)

				.when()
				.post(EndPoints.createProject);

		//capture the project id from the Response
		String expData = rLib.getJSONData(resp, "projectId");
		System.out.println(expData);

		//step =4 Verify in Database
		String query="select * from project";
		String actData = dLib.ExecuteQueryAndGetData(query, 1, expData);
		Reporter.log(actData, true);

		Assert.assertEquals(expData, actData);
		Reporter.log("data verification successful", true);
	}

}
