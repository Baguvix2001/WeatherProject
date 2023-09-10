package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.ArrayList;
import java.util.List;

import static constants.Constants.Credentials.API_URL;
import static constants.Constants.Credentials.APPID;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

public class WeatherApiTest {
    //    public void getWeatherByCityName (String cityName) {
//        Specifications.requestSpec(API_URL);
//        List<WeatherAPI> data = given()
//                .when()
//                .get("?q="+ cityName + "&appid=" + APPID + "&units=metric")
//                .then().log().all()
//                .extract().body().jsonPath().getList("data", WeatherAPI.class);
//        List<String> name = data.stream().map(WeatherAPI::getName).toList();
//    }
    public Object cityNamesApi(String cityName) {
        RestAssured.baseURI = API_URL;
        List<String> response = given()
                .param("q", cityName)
                .param("appid", APPID)
                .param("units", "metric")
                .when()
                .get("/get")
                .then().log().all()
                .body("list.name", notNullValue())
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().path("list.name");
        System.out.println(response);
       return response;
    }

    public Object weatherResultsApi (String cityName) {
        RestAssured.baseURI = API_URL;
        List<Float> response = given()
                .param("q", cityName)
                .param("appid", APPID)
                .param("units", "metric")
                .when()
                .get("/get")
                .then().log().all()
                .body("list.main.temp", notNullValue())
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().path("list.main.temp");
        System.out.println("Результат в кельвинах"+ response);
        List <Integer> celsiusResult = new ArrayList<>();
        for (float x : response) {
         float celsiusTemp = (float) (x - 273.15);
            int roundedCelsiusTemperature = Math.round(celsiusTemp);
            celsiusResult.add(roundedCelsiusTemperature);
        }
        return celsiusResult;
    }
}

