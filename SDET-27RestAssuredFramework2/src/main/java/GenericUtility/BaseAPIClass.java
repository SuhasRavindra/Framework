package GenericUtility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.SQLException;

public class BaseAPIClass {

	public DataBaseUtility dLib=new DataBaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredUtility rLib=new RestAssuredUtility();

	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		baseURI="http://localhost";
		port=8084;		

		dLib.connecttoDB();
		System.out.println("=======Database connection Established");
	}

	@AfterSuite
	public void asConfig() throws Throwable, Throwable  {

		dLib.closeDB();
		System.out.println("=======Database connection closed");

	}
}
