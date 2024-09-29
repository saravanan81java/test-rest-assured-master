
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class GetWeather {
	//RestAssured tutorial
	public static void main(String[] args){
     RestAssured.baseURI = "https://demoqa.com/utilities/weather/city";
     
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
		
		String responseBody = response.getBody().asString();
		int statusCode = response.getStatusCode();
		System.out.println("Response Body:    "+responseBody);
		System.out.println("Response Code: "+statusCode );
	}

}
