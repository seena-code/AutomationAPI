package com.blazedemo.test;

import com.blazedemo.base.Base;
import com.blazedemo.base.WebDriverTestBase;
import com.blazedemo.base.WebDriverTestBase.browserType;
import com.blazedemo.pageobjects.ConfirmationPage;
import com.blazedemo.pageobjects.HomePage;
import com.blazedemo.pageobjects.LoginPage;
import com.blazedemo.pageobjects.PurchasePage;
import com.blazedemo.pageobjects.RegisterPage;
import com.blazedemo.pageobjects.ReservePage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class SearchFlight  {
    public WebDriver driver;
    browserType type = browserType.CHROME_WIN;
    HomePage homePage ;
    ReservePage reservePage ;
    PurchasePage purchasePage;
    String baseURL = "https://blazedemo.com/";

    @BeforeClass
    public void Setup(){

        driver = WebDriverTestBase.getDriver(type);
        driver.get(baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        reservePage = new ReservePage(driver);
    }
    @AfterClass
    public void TearDown(){

        driver.quit();

    }
    
	/*
	 * Scenario - validates the end to end flow of flight booking and asserts with
	 * the assignment of booking id
	 */

@Test
    public void SearchFlight() throws Exception
    {


        String departureCity ="Paris";
        String destinationCity ="London";
        homePage.SearchFlight(departureCity,destinationCity);
        reservePage.validateHeader().contains(departureCity);
        reservePage.validateHeader().contains(destinationCity);
        reservePage.validatetableDpartureHeader().contains(departureCity);
        reservePage.validatetableDestinationHeader().contains(destinationCity);
        purchasePage= reservePage.clickFlightToBeChosen("VA43");
        String title = purchasePage.validateTitle();
        assert (title.contains("Your flight from TLV to SFO has been reserved"));
        purchasePage.enterName("Seena");
        purchasePage.enterAddress("Richmond");
        purchasePage.enterCity("Bangalore");
        purchasePage.enterState("KA");
        purchasePage.enterZipCode("7777");
        purchasePage.selectCardType("visa");
        purchasePage.enterCreditCardNumber("989898999999");
        purchasePage.enterMonth("10");
        purchasePage.enterYear("2021");
        purchasePage.nameOnCard("seena");
        purchasePage.clickChkbxRemember();
        ConfirmationPage confirmationPage= purchasePage.clickBtnPurchaseFlight();
        confirmationPage.validateTitle().contains("Thank you for your purchase today!");
        HashMap<String,String> testData = new HashMap<>();
        HashMap<String,String> expectedTestData = new HashMap<>();
        testData.put("Status", "PendingCapture");
        testData.put("Amount", "555 USD");
        testData.put("Auth Code", "888888");
        expectedTestData= confirmationPage.verifyPurchaseDetails();
        String valueID= expectedTestData.get("Id");
        assertTrue(!valueID.isEmpty()); 

      }




}
