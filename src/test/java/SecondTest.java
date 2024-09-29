import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;

public class SecondTest {
	
	
	//@Test(enabled=false)
	void getMethodTest() {
		String url= "https://reqres.in/api/users?page=2";
		//given contains body and header parameters
		
		Response res=
				
		given().
		
		//when contains URl and methods
		when().get(url).
		
		//we can do a response validation in then()
		then().statusCode(200).
		log().body().
		extract().response();
		
		int statusCode = res.getStatusCode();
		String responseMessage = res.getBody().asString();
		
		Assert.assertEquals(responseMessage.contains("michael.lawson@reqres.in"),true);
		
		
	}
	
	@Test
	void postMethodTest() {
		
		String bodydata="{\n" + 
				"    \"email\": \"eve.holt@reqres.in\",\n" + 
				"    \"password\": \"pistol\"\n" + 
				"}";
		
		String requestLocation = "src/test/java/SecondTest.json";
		File fis = new File(requestLocation);
		
		HashMap mapdata = new HashMap();
		mapdata.put("email", "eve.holt@reqres.in");
		mapdata.put("password", "pistol");
		
		
	//given contains body and header parameters	
     given()
     .body(fis).
     // whane contains method name and URL
     when().post("https://reqres.in/api/register").
     // then contains response validation
     then().statusCode(400).log().body();
     
     
     
	}

}
