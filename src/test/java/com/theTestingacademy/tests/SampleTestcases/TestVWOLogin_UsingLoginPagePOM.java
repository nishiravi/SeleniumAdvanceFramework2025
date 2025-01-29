package com.theTestingacademy.tests.SampleTestcases;

import com.theTestingacademy.pages.PageObjectModel.VMO.LoginPage_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_UsingLoginPagePOM {


    @Description("Verify with valid credential Login is successful")
    @Owner("Nishi Ravi")
    @Test
    public void testLoginValidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        LoginPage_POM login = new LoginPage_POM(driver);
        login.logintoVMOwithValidcredentials("admin@gmail.com", "admin@123");
    }

    @Description("Verify invalid credential Login throws error msg")
    @Owner("Nishi Ravi")
    @Test
    public void testLoginNegativeCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        LoginPage_POM login = new LoginPage_POM(driver);
        String errormsgText = login.logintoVMOwithInValidcredentials("abc", "123");
        assertThat(errormsgText).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(errormsgText, "Your email, password, IP address or location did not match");
        driver.quit();

    }

}
