package com.theTestingacademy.pages.PageObjectModel.OrangeHR;

import com.theTestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRDashBoardPage_POM extends CommonToAllPages {
    public static WebDriver driver;

    public OrangeHRDashBoardPage_POM(WebDriver driver)
    {
        this.driver=driver;
    }

    // page locators
    private By dashboardUsername=By.cssSelector(".oxd-text--h6");

    public String  getdashboradusername()
    {
        presenceOfElement(dashboardUsername);
       return getTextmsg(dashboardUsername);
    }

}
