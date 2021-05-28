package com.blazedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(id = "password")
    public WebElement txtPswd;

    @FindBy(className = "btn btn-primary")
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

    public void clickBtnLogin()

    {
        btnLogin.click();
    }

    public void displaySuccessPageValidation()

    {
        sucessPage.isDisplayed();
    }


}



