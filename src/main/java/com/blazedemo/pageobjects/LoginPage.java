package com.blazedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.base.Base;

public class LoginPage extends Base {

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "password")
    public WebElement txtPswd;


    @FindBy( css= "button.btn")
    public WebElement btnLogin;

    @FindBy(className = "remember")
    public WebElement chkRemember;

    @FindBy(partialLinkText = "Forgot Your Password?")
    public WebElement lnkForgotPswd;

    @FindBy(partialLinkText = "BlazeDemo")
    public WebElement lnkHomePage;

    @FindBy(className = "panel-heading")
    public WebElement titleLogin;

    @FindBy(partialLinkText = "Register")
    public WebElement lnkRegister;

    @FindBy(partialLinkText = "Login")
    public WebElement lnkLogin;

    @FindBy(className = "message")
    public WebElement sucessPage;
    
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    public void enterEmailAdress(String emailAddress)

    {
        txtEmail.sendKeys(emailAddress);
    }

    public void enterPassword(String password)

    {
        txtPswd.sendKeys(password);
    }

    public void clickChkBoxRemember()

    {
        chkRemember.click();
    }

    public Boolean clickBtnLogin()

    {
        btnLogin.click();
        return true;
    }

    public void displaySuccessPageValidation()

    {
        sucessPage.isDisplayed();
    }
    
    public RegisterPage clickRegister()

    {
        lnkRegister.click();
        return PageFactory.initElements(driver, RegisterPage.class);

    }


}



