package com.blazedemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

    @FindBy(id = "name")
    public WebElement txtName;

    @FindBy(id = "password")
    public WebElement txtPswd;

    @FindBy(id = "password-confirm")
    public WebElement txtPswdConfirm;

    @FindBy(className = "company")
    public WebElement txtCompany;

    @FindBy(className = "btn btn-primary")
    public WebElement btnRegister;

    public void newUserName(String name)
    {
          txtName.sendKeys(name);
    }

    public void enterPassword(String pswd)
    {
        txtPswd.sendKeys(pswd);
    }

    public void enterPswdConfirm(String pswd)
    {
        txtPswdConfirm.sendKeys(pswd);
    }

    public void enterCompany(String companyName)
    {
        txtCompany.sendKeys(companyName);
    }

    public void clickButtonRegister()
    {
        btnRegister.click();
    }
}
