package com.blazedemo.pageobjects;

import com.blazedemo.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReservePage extends Base {

    @FindBy(tagName = "h3")
    public WebElement titleReservePage;

    @FindBy(css = "table th:nth-of-type(4)")
    public WebElement tableDpartureHeader;

    @FindBy(css = "table th:nth-of-type(5)")
    public WebElement tableDestinationHeader;

    @FindBy(css = "table tr:nth-of-type(1) td > input")
    public WebElement btnChooseFlight;

    @FindBy(xpath = "//form[@name ='VA43']/following-sibling::td/input")
    public WebElement btnChooseFlightElements;

    public ReservePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    public void clickChooseFlight()
    {
        btnChooseFlight.click();
    }

    public PurchasePage clickFlightToBeChosen(String airlineNumber)
    {
        String locator = "//form[@name ='"+airlineNumber+"']/following-sibling::td/input";
        driver.findElement(By.xpath(locator)).click();
        return PageFactory.initElements(driver, PurchasePage.class);

    }

    public String validateHeader()
    {
       return titleReservePage.getText();
    }

    public String validatetableDpartureHeader()
    {
        return tableDpartureHeader.getText();
    }

    public String validatetableDestinationHeader()
    {
        return tableDestinationHeader.getText();
    }



}
