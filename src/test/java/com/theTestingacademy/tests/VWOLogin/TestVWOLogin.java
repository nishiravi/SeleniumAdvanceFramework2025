package com.theTestingacademy.tests.VWOLogin;

import com.theTestingacademy.base.CommanToAllTest;
import com.theTestingacademy.driver.DriverManager;
import com.theTestingacademy.pages.PageObjectModel.VMO.VWODashboardPage_POM;
import com.theTestingacademy.pages.PageObjectModel.VMO.VWOLoginPage_POM;
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
        VWOLoginPage_POM login = new VWOLoginPage_POM(DriverManager.getDriver());
        login.logintoVMOwithValidcredentials(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
        VWODashboardPage_POM dashboardPagePom=new VWODashboardPage_POM(DriverManager.getDriver());
        String displayedusername=dashboardPagePom.loogedinuserName();
        Assert.assertEquals(displayedusername,PropertiesReader.readKey("expected_username"));
        System.out.println(dashboardPagePom.dashBoardsuccessmsg());

    }

    @Description("Verify invalid credential Login throws error msg")
    @Owner("Nishi Ravi")
    @Test
    public void testVWOLoginNegtestive() throws InterruptedException {
        VWOLoginPage_POM login = new VWOLoginPage_POM(DriverManager.getDriver());
        String errormsgText = login.logintoVMOwithInValidcredentials(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        assertThat(errormsgText).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errormsgText, PropertiesReader.readKey("error_message"));
        System.out.println(errormsgText);
        driver.quit();

    }

}
