package com.theTestingacademy.pages.PageObjectModel.VMO;

import com.theTestingacademy.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_POM extends CommonToAllPages {

    WebDriver driver;
public DashboardPage_POM(WebDriver driver)
{
    this.driver=driver;
}
// Dashboard page locators
    private By dashboardusername=By.xpath("//span[@data-qa='lufexuloga']");
    private By dashboradsucessmsg=By.xpath("//p[@class='page-sub-title']");
// page actions
    //method to to get the looged in username
    public String loogedinuserName()
    {
        presenceOfElement(dashboardusername);
        return getTextmsg(dashboardusername);
    }
    public String dashBoardsuccessmsg()
    {
       return getTextmsg(dashboradsucessmsg);
    }
}
