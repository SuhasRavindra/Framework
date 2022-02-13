package DifferentWaysToPostRequest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;

public class VerifyUsingHamcrestTest {
	@Test
	public void verify()  {
		
		when()
		  .get("http://localhost:8084/projects")
		 .then()
		 .assertThat().time(Matchers.lessThan(5L),TimeUnit.MILLISECONDS)
		 .log().all();
	}

}
