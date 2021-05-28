package com.blazedemo.APIHelper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.json.Json;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIHelper {
    Gson gson = new Gson();
    private final String URL = "https://api.spacexdata.com";

//check the versions of API
    public  List<String> getDetails() throws Exception {
        List<String> elementShips;

        try {
            Response response = RestAssured.given().get(URL+"/v4/launches/latest");
            Response response2 = RestAssured.given().get(URL+"/v3/launches/latest");

            if (response2.getStatusCode() == 200) {
                System.out.print("The get call is successful with response body as "+ response2.getBody().asString());
            } else {
                throw new Exception("Failure while fetching the latest launch data. The response code was:" + response.getStatusCode() +
                        "and the response body received is: " + response.getBody().asString());

            }

            if (response.getStatusCode() == 200) {
                JsonPath path = new JsonPath(response.getBody().asString());
                HashMap<String,Object> element = path.get("fairings");
                elementShips= (List<String>) element.get("ships");

            } else {
                throw new Exception("Failure while fetching the latest launch data. The response code was:" + response.getStatusCode() +
                        "and the response body received is: " + response.getBody().asString());
            }

            return elementShips;
        } catch (Exception var6) {
            throw new Exception(var6.getMessage());
        }
    }

    //scenario to test basic API methods
    public Response basicAPI(String URL) throws Exception {
            	
            return RestAssured.given().post(URL);            
    }

    //check the variation of path param
    public Response getVariationOfPathParam(String URL) throws Exception {
          try {
            Response response = RestAssured.given().get(URL);
            if (response.getStatusCode() != 200) {
                throw new Exception("Failure while fetching the launch data. The response code was:" + response.getStatusCode() +
                        "and the response body received is: " + response.getBody().asString());
            } else return response;

        } catch (Exception var6) {
            throw new Exception(var6.getMessage());
        }
    }

}
