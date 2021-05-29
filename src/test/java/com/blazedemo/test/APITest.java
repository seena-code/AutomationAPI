package com.blazedemo.test;

import com.blazedemo.APIHelper.APIHelper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.restassured.response.Response;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITest {

	
	/* Scenario 1 - To validate the API call with different path parameters */
	
	  @Test public void verifyPathParam() throws Exception{ 
	  SoftAssert softAssert =new SoftAssert(); Response allResponses = new
	  APIHelper().getVariationOfPathParam("https://api.spacexdata.com/v4/launches"); 
	  Response responseWithLatest = new APIHelper().getVariationOfPathParam("https://api.spacexdata.com/v4/launches/latest"); 
	  softAssert.assertTrue(new Gson().fromJson(allResponses.getBody().asString(), JsonArray.class).size() >0); 
	  System.out.print(new Gson().fromJson(allResponses.getBody().asString(),JsonArray.class).size()); 
	  softAssert.assertTrue(new Gson().fromJson(allResponses.getBody().asString(),JsonArray.class).size()>0);
	  
	  }
	  
	 /* Scenario 2 - To validate the Basic method and
	  *  assert the status code 
	  *  NOTE - This test fails as the expected status code 405 is not achieved*/
	  
	  @Test public void verifyBasicMethods() throws Exception{ SoftAssert
	  softAssert = new SoftAssert(); Response response = new
	  APIHelper().basicAPI("https://api.spacexdata.com/v4/launches/latest");
	  softAssert.assertTrue(response.getStatusCode()==405);
	  
	  if (response.getStatusCode() == 405) {
	  System.out.print("The response is as per the Rest Specifications "+
	  response.getBody().asString());
	  
	  } else { throw new
	  Exception("The response is not as per the Rest Specifications" +response.getStatusCode() + "and the response body received is: " +response.getBody().asString()); 
	  }
	  
	  }
	 

	/* Scenario 3 - To validate the versions with response, 
	 * and asserting the size of the element extracted is more than 1 */
	  
	@Test
	public void verifyGetDetails() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		List<String> responseElement = new APIHelper().getDetails();
		softAssert.assertTrue(responseElement.size() > 1);

	}

}
