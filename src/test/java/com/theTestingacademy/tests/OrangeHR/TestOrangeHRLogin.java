package com.theTestingacademy.tests.OrangeHR;

import com.theTestingacademy.base.CommanToAllTest;
import com.theTestingacademy.driver.DriverManager;
import com.theTestingacademy.pages.PageObjectModel.OrangeHR.OrangeHRDashBoardPage_POM;
import com.theTestingacademy.pages.PageObjectModel.OrangeHR.OrangeHRLoginPage_PMO;
import com.theTestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOrangeHRLogin extends CommanToAllTest {

    @Description("Verify Login for Valid Credentials")
    @Owner("Nishi Ravi")
    @Test
    public void testPositiveLogin()
    {
        OrangeHRLoginPage_PMO login=new OrangeHRLoginPage_PMO(DriverManager.getDriver());

        login.LoginWithValidCredential(PropertiesReader.readKey("ohr_username"),PropertiesReader.readKey("ohr_password"));
        OrangeHRDashBoardPage_POM dp=new OrangeHRDashBoardPage_POM(DriverManager.getDriver());
        String msg=dp.getdashboradusername();
        Assert.assertEquals(msg,PropertiesReader.readKey("ohr_expected_username"));
        System.out.println("Login Success");
    }
}
