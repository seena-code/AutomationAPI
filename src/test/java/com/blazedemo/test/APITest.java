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

	
	  @Test public void verifyPathParam() throws Exception{ 
	  SoftAssert softAssert =new SoftAssert(); Response allResponses = new
	  APIHelper().getVariationOfPathParam("https://api.spacexdata.com/v4/launches"); 
	  Response responseWithLatest = new APIHelper().getVariationOfPathParam("https://api.spacexdata.com/v4/launches/latest"); 
	  softAssert.assertTrue(new Gson().fromJson(allResponses.getBody().asString(), JsonArray.class).size() >0); 
	  System.out.print(new Gson().fromJson(allResponses.getBody().asString(),JsonArray.class).size()); 
	  softAssert.assertTrue(new Gson().fromJson(allResponses.getBody().asString(),JsonArray.class).size()>0);
	  
	  }
	  
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
	 

	@Test
	public void verifyGetDetails() throws Exception {

		SoftAssert softAssert = new SoftAssert();
		List<String> responseElement = new APIHelper().getDetails();
		softAssert.assertTrue(responseElement.size() > 1);

	}

}
