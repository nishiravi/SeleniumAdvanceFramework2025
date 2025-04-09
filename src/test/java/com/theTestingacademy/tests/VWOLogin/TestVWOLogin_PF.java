package com.theTestingacademy.tests.VWOLogin;

import com.theTestingacademy.base.CommanToAllTest;
import com.theTestingacademy.driver.DriverManager;
import com.theTestingacademy.pages.PageFactory.VMO.VMOLoginpage_PF;
import com.theTestingacademy.pages.PageObjectModel.VMO.VWODashboardPage_POM;
import com.theTestingacademy.pages.PageObjectModel.VMO.VWOLoginPage_POM;
import com.theTestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theTestingacademy.driver.DriverManager.driver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_PF extends CommanToAllTest {


    @Description("Verify with valid credential Login is successful")
    @Owner("Nishi Ravi")
    @Test
    public void testVWOLoginPositive() throws InterruptedException {
        VMOLoginpage_PF login = new VMOLoginpage_PF(DriverManager.getDriver());
        driver.get(PropertiesReader.readKey("url"));
        login.logintoVMOwithValidcredentials(PropertiesReader.readKey("username"), PropertiesReader.readKey("password"));
        System.out.println(" login success using PageFactory");

    }


}
