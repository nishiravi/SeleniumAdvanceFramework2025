package com.theTestingacademy.pages.PageObjectModel.OrangeHR;

import com.theTestingacademy.base.CommonToAllPages;
import com.theTestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRLoginPage_PMO extends CommonToAllPages {

    public static WebDriver driver;
    // intialize the driver
    public OrangeHRLoginPage_PMO(WebDriver driver)
    {
        this.driver=driver;
    }
    // Locators present in the login page
    private By username=By.xpath("//input[@placeholder='Username']");
    private By password=By.name("password");
    private By submit_button=By.cssSelector(".orangehrm-login-button");
    private By forgot_password=By.cssSelector(".orangehrm-login-forgot-header");
    private By error_message=By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error'][1]/p");
    //page Actions

    public void LoginWithValidCredential(String userName,String passWord)
    {
        driver.get(PropertiesReader.readKey("orange_hr_url"));
        presenceOfElement(username);
        enterInput(username,userName);
        enterInput(password,passWord);
        clickelement(submit_button);
    }

    public String LoginWithInValidCredential(String userName,String passWord)
    {
        driver.get(PropertiesReader.readKey("orange_hr_url"));
        presenceOfElement(username);
        enterInput(username,userName);
        enterInput(password,passWord);
        clickelement(submit_button);
        presenceOfElement(error_message);
        return getTextmsg(error_message);

    }
}
