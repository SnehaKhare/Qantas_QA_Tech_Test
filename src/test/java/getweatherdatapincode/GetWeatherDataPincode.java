package getweatherdatapincode;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetWeatherDataPincode {
	
	@Step("Test API's call with Pincode")
	@Test(dataProvider ="Pincode" )
	public void getData(Number Pincode) {
		// TODO Auto-generated method stub
		RestAssured.baseURI ="http://api.weatherbit.io/v2.0";
		String response = given().log().all().queryParam("key", "4fd107bb82dd44cda594f42491cdf8d0")	
		.pathParam("postal_code", Pincode)
		.when().get("/current?postal_code={postal_code}")
		.then().assertThat().statusCode(200).body("count", equalTo(1))
		.extract().response().asString();
		System.out.println(response);
	
		
	}
	
	@DataProvider(name="Pincode")
	public Object[] setupData()
	{
		return new Object[] {2150,2565,482001,0,44101,-22};
	}
		

}
