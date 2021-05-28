package com.blazedemo.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPage {

    @FindBy(id = "email")
    public WebElement txtEmail;

    @FindBy(className  = "btn btn-primary")
    public WebElement btnReset;


}
