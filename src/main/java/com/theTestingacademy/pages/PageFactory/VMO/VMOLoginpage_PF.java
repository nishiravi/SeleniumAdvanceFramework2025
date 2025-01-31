package com.theTestingacademy.pages.PageFactory.VMO;

import com.theTestingacademy.base.CommonToAllPages;
import com.theTestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VMOLoginpage_PF extends CommonToAllPages {

    public VMOLoginpage_PF(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
   //Locators
    @FindBy(id="login-username")
    private WebElement username;
    @FindBy(id="login-password")
    private WebElement password;
    @FindBy(id="js-login-btn")
    private WebElement submittbutton;
    @FindBy(xpath="//button[@onclick='login.goToSSOView()']")
    private WebElement SignInSSO;
    //page actions

    public void logintoVMOwithValidcredentials(String userName, String passWord) {
        enterInput(username, userName);
        enterInput(password, passWord);
        clickelement(submittbutton);
    }
}
