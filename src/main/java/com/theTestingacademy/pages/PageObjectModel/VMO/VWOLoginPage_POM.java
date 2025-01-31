package com.theTestingacademy.pages.PageObjectModel.VMO;

import com.theTestingacademy.base.CommonToAllPages;
import com.theTestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VWOLoginPage_POM extends CommonToAllPages {


    // webDriver installation
    public WebDriver driver;

    public VWOLoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }


    //page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By submitButton = By.id("js-login-btn");
    private By submiterrormsg = By.id("js-notification-box-msg");
    private By forgotpassword = By.xpath("//li/button[@onclick='login.gotoForgotPasswordView()']");
    private By remembermecheckbox = By.cssSelector(".checkbox-radio-button.ng-scope");
    private By signInSSO = By.xpath("//button[@onclick='login.goToSSOView()']");


    //page actions

    public void logintoVMOwithValidcredentials(String userName, String passWord) {
        driver.get(PropertiesReader.readKey("url"));
        enterInput(username, userName);
        enterInput(password, passWord);
        clickelement(submitButton);
    }

    public String logintoVMOwithInValidcredentials(String userName, String passWord) throws InterruptedException {

        driver.get(PropertiesReader.readKey("url"));
        enterInput(username, userName);
        enterInput(password, passWord);
        clickelement(submitButton);
        Thread.sleep(3000);
        String errormsg = getTextmsg(submiterrormsg);
        return errormsg;
    }

}
