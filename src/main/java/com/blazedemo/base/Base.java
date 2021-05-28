package com.blazedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    public WebDriver driver;
    String baseURL = "https://blazedemo.com/";

    public Base(WebDriver driver) {
        this.driver = driver;
       
    }

    @BeforeClass
    public void launchApplication(){
        setChromeDriverProperty();
        this.driver = new ChromeDriver();
        driver.get(baseURL);

    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

    private static void setChromeDriverProperty(){
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
    }
}
