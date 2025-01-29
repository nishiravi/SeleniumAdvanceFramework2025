package com.theTestingacademy.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.theTestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPages {
    // If you want to call something before every Page Object Class call, Put your Code here");
    // Open File, Open Data Base Connection You can write code here


    // method to click an element using locator
    public void clickelement(By by)
    {
        getDriver().findElement(by).click();
    }

    // method to click an WebElement directly
    public void clickelement(WebElement webelement)
    {
        webelement.click();
    }

    // method to enter the input using locator
    public void enterInput(By by,String key)
    {
        getDriver().findElement(by).sendKeys(key);
    }

    // method to enter the input on webElement
    public void enterInput(WebElement webelement,String key)
    {
        webelement.sendKeys(key);
    }
    // to capture the text
    public String  getTextmsg(By by)
    {
        return getDriver().findElement(by).getText();
    }

    //Explicit wait on the loctor of the elements
    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }
}
