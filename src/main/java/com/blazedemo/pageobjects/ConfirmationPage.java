package com.blazedemo.pageobjects;

import com.blazedemo.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmationPage extends Base {

    @FindBy( tagName = "h1")
    public WebElement txtName;

    @FindBy( css = ".table tr")
    public List<WebElement> tableContent;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);

    }

    public HashMap verifyPurchaseDetails()
    {
        HashMap<String,String> rowText = new HashMap<>();
        for (int i =0 ;i<tableContent.size()-1;i++)
        {
            String key = tableContent.get(i).findElement(By.xpath("//table//tr[" + (i+1)+ "]/td[1]")).getText();
            String value = tableContent.get(i).findElement(By.xpath("//table//tr[" + (i+1)+ "]/td[2]")).getText();
            rowText.put(key,value);
            
        }
        return rowText;
    }

    public String validateTitle()
    {
       return txtName.getText();
    }




    }


