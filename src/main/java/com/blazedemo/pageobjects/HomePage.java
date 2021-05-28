package com.blazedemo.pageobjects;

import com.blazedemo.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends Base {

    @FindBy(name = "fromPort")
    public WebElement departureCity;

    @FindBy(name = "toPort")
    public WebElement destinationCity;

 //   @FindBy(className = "btn btn-primary")
    //public WebElement btnSubmit;

    @FindBy(css = "input.btn")
    public WebElement btnSubmit;

    @FindBy(linkText = "destination of the week! The Beach!")
    public WebElement lnkDestination;

    @FindBy(linkText = "Travel The World")
    public WebElement lnkTravel;

    @FindBy(linkText = "home")
    public WebElement lnkHome;

    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void chooseDepartureCity(String departureCityValue)
    {
        Select selectDepartureCity = new Select(departureCity);
        selectDepartureCity.selectByValue(departureCityValue);

    }

    public void chooseDestinationCity(String destinationCityValue)
    {
        Select selectDestinationCity = new Select(destinationCity);
        selectDestinationCity.selectByValue(destinationCityValue);

    }

    public void SearchFlight(String departureCity,String destinationCity )
    {

        chooseDepartureCity(departureCity);
        chooseDestinationCity(destinationCity);
        clickOnSubmit();

    }

    public void clickOnSubmit()
    {
        btnSubmit.click();
    }
}
