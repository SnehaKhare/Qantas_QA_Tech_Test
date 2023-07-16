package getweatherdatapincode;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Step;
import io.restassured.RestAssured;

public class GetWeatherDataLanLon {
	
	@Step("Test API's call with longitude and latitude")
	@Test(dataProvider ="lanData" )
	public void getData(Number latData, Number lonData) {
		// TODO Auto-generated method stub
		RestAssured.baseURI ="http://api.weatherbit.io/v2.0";
		String response = given().log().all().queryParam("key", "4fd107bb82dd44cda594f42491cdf8d0")	
		.pathParam("lat", latData)
		.pathParam("lon",lonData)
		.when().get("/current?lat={lat}&lon={lon}")
		.then().assertThat().statusCode(200).body("count", equalTo(1))
		.extract().response().asString();
		System.out.println(response);
	
		
	}
	
	@DataProvider(name="lanData")
	public Object[][] setupData()
	{
		return new Object[][] {{51.5072,-0.1276},{25.2221,15.656},{34.878,6.2357},{0,0},{-23.22,-33.87}};
	}

}
