package com.theTestingacademy.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM {


    // webDriver installation
    WebDriver driver;
    public LoginPage_POM(WebDriver driver)
    {
   this.driver=driver;
    }


    //page locators

private By username= By.id("login-username");
    private By password= By.id("login-password");
    private By submitButton= By.id("js-login-btn");
    private By submterrormsg=By.id("js-notification-box-msg");
    private By forgotpassword= By.xpath("//li/button[@onclick='login.gotoForgotPasswordView()']");
    private By remembermecheckbox=By.cssSelector(".checkbox-radio-button.ng-scope");
    private By signInSSO=By.xpath("//button[@onclick='login.goToSSOView()']");




    //page actions

    public void logintoVMOwithValidcredentials(String userName,String passWord)
    {
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(passWord);
        driver.findElement(submitButton).click();
    }

    public String logintoVMOwithInValidcredentials(String userName,String passWord) throws InterruptedException {
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(passWord);
        driver.findElement(submitButton).click();
        Thread.sleep(3000);
        String errormsg=driver.findElement(submterrormsg).getText();
        return errormsg;
    }

}
