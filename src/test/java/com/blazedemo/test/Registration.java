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


public class Registration  {
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
	* Scenario - validates the registration flow
	*/

	@Test
	public void RegisterNewUser() throws Exception
	{

		LoginPage loginPage=homePage.clickOnLogin();
		RegisterPage registerPage= loginPage.clickRegister();
		
		registerPage.newUserName("automationuser");
		registerPage.enterCompany("Automation");
		registerPage.enterPassword("Qwerty@123*");
		registerPage.enterPswdConfirm("Qwerty@123*");	
		registerPage.clickButtonRegister();
				
	  
	 }


}
