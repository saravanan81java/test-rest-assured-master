
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POJO.Loginpojo;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Logintest {
	
	String URL = "https://reqres.in/api/login";
	 String arg = "{\n" + 
	 		"    \"email\": \"eve.holt@reqres.in\",\n" + 
	 		"    \"password\": \"cityslicka\"\n" + 
	 		"}";
	
	 //Testcase1
	@Test
	void login() {
		
		Loginpojo po = new Loginpojo();
		
		po.setEmail("eve.holt@reqres.in");
		po.setpassword("cityslicka");
	/*	
		String s = RandomStringUtils.randomAlphanumeric(5);
		System.out.println("Random value----------- "+s);
	*/	
		
		Response res=
		
		given()
		.body(po)
		.log().all()
		.contentType("application/json")
		.when()
		.post(URL)
		.then().statusCode(200)
		.log().all()
		.extract().response();
		
		String responseValue = res.asString();
		
		JsonPath js = new JsonPath(responseValue);
		String tokenValue = js.getString("token");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(tokenValue, "QpwL5tke4Pnpja7X");
		System.out.println("Validation is comepleted..........");
		//Assert.assertEquals(tokenValue, "QpwL5tke4Pnpja7X");
		
	}
	
	//Test case 2
	//@Test
   void logintest2() {
		
		Loginpojo po = new Loginpojo();
		
		po.setEmail("eve.holt@reqres.in");
		po.setpassword("");
		
		Response res=
		
		given()
		.body(po)
		.log().all()
		.contentType("application/json")
		.when()
		.post(URL)
		.then().statusCode(400)
		.log().all()
		.extract().response();
		
		String responseValue = res.asString();
		
		JsonPath js = new JsonPath(responseValue);
		String tokenValue = js.getString("token");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(tokenValue, "QpwL5tke4Pnpja7X");
		System.out.println("Validation is comepleted..........");
		//Assert.assertEquals(tokenValue, "QpwL5tke4Pnpja7X");
		
	}
	
	
}
