import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;

public class FirstTest {
	
	
	@Test(enabled=false)
	void firstTest() {
		String url = "http://reqres.in/api/users?page=2";
		given().
		when().get(url).
		then().statusCode(200)
		.log().body();
	}
	
	
	
	@Test(enabled=true)
	void PostMethodTest() {
		
		String Url="https://reqres.in/api/users";
		
		String contentType = "application/json"; 
		
		String Mapbody = "{\n" + 
				"    \"name\": \"morpheus\",\n" + 
				"    \"job\": \"leader\"\n" + 
				"}";
		
		//JSONObject requestParams =
		
		HashMap data = new HashMap();
		data.put("name", "morpheus");
		data.put("job", "leader");
		
		String requestLocation = "src/test/java/FirstTest.json";
		File fis = new File(requestLocation);
		
		//JsonObject js = new JsonObject();
		//Restassured Script
		Response res=
		given()
		.contentType(contentType)
		.body(data).
		
		when().post(Url).
		
		then().statusCode(201).log().body().extract().response();
		
		String jsonString = res.asString();
		int statusCode = res.getStatusCode();
		
		//jsonString.
		
		assertEquals(jsonString.contains("morpheus"),true);
		
		JsonPath js = new JsonPath(jsonString);
		
		String name = js.get("name");
		Assert.assertEquals(name, "morpheus");
		
		
	}

}
