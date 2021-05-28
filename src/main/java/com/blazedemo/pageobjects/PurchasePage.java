package com.blazedemo.pageobjects;

import com.blazedemo.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage extends Base {

    @FindBy( id = "inputName")
    public WebElement txtName;

    @FindBy( id = "address")
    public WebElement txtAddress;

    @FindBy( id = "city")
    public WebElement txtCity;

    @FindBy( id = "state")
    public WebElement txtState;

    @FindBy( id = "zipCode")
    public WebElement txtZipCode;

    @FindBy( id = "cardType")
    public WebElement ddCardType;

    @FindBy( id = "creditCardNumber")
    public WebElement txtCreditCardNumber;

    @FindBy( id = "creditCardMonth")
    public WebElement txtCreditCardMonth;

    @FindBy( id = "creditCardYear")
    public WebElement txtCreditCardYear;

    @FindBy( id = "nameOnCard")
    public WebElement txtNameOnCard;

    @FindBy( id = "rememberMe")
    public WebElement chkRememberMe;

    @FindBy( css= "input.btn")
    public WebElement btnPurchaseFlight;

    @FindBy( tagName = "h2")
    public WebElement titlePurchasePage;



    public void enterName(String name)

    {
        txtName.sendKeys(name);
    }

    public void enterAddress(String address)

    {
        txtAddress.sendKeys(address);
    }

    public void enterCity(String city)

    {
        txtCity.sendKeys(city);
    }

    public void enterState(String state)

    {
        txtState.sendKeys(state);
    }

    public void enterZipCode(String zipcode)

    {
        txtZipCode.sendKeys(zipcode);
    }

    public void enterCreditCardNumber(String creditcardNumber)

    {
        txtCreditCardNumber.sendKeys(creditcardNumber);
    }

    public void enterMonth(String month)

    {
        txtCreditCardMonth.clear();
        txtCreditCardMonth.sendKeys(month);

    }
    public PurchasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    public String validateTitle()

    {
       return titlePurchasePage.getText();

    }


    public void enterYear(String month)

    {
        txtCreditCardYear.clear();
        txtCreditCardYear.sendKeys(month);

    }

    public void nameOnCard(String nameOnCard)

    {
        txtNameOnCard.sendKeys(nameOnCard);

    }

    public void clickChkbxRemember()

    {
        chkRememberMe.click();
    }

    public ConfirmationPage clickBtnPurchaseFlight()

    {
        btnPurchaseFlight.click();
        return PageFactory.initElements(driver, ConfirmationPage.class);

    }

    public void selectCardType(String cardType)

    {
        Select selectCard = new Select(ddCardType);
        selectCard.selectByValue(cardType);
    }



}
