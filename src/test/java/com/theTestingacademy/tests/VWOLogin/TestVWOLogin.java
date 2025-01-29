package com.theTestingacademy.tests.VWOLogin;

import com.theTestingacademy.base.CommanToAllTest;
import com.theTestingacademy.driver.DriverManager;
import com.theTestingacademy.pages.PageObjectModel.VMO.DashboardPage_POM;
import com.theTestingacademy.pages.PageObjectModel.VMO.LoginPage_POM;
import com.theTestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theTestingacademy.driver.DriverManager.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin extends CommanToAllTest {


    @Description("Verify with valid credential Login is successful")
    @Owner("Nishi Ravi")
    @Test
    public void testVWOLoginPositive() throws InterruptedException {
        LoginPage_POM login = new LoginPage_POM(DriverManager.getDriver());
        login.logintoVMOwithValidcredentials(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
        DashboardPage_POM dashboardPagePom=new DashboardPage_POM(DriverManager.getDriver());
        String displayedusername=dashboardPagePom.loogedinuserName();
        Assert.assertEquals(displayedusername,PropertiesReader.readKey("expected_username"));
        System.out.println(dashboardPagePom.dashBoardsuccessmsg());

    }

    @Description("Verify invalid credential Login throws error msg")
    @Owner("Nishi Ravi")
    @Test
    public void testVWOLoginNegtestive() throws InterruptedException {
        LoginPage_POM login = new LoginPage_POM(DriverManager.getDriver());
        String errormsgText = login.logintoVMOwithInValidcredentials(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        assertThat(errormsgText).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errormsgText, PropertiesReader.readKey("error_message"));
        System.out.println(errormsgText);
        driver.quit();

    }

}
