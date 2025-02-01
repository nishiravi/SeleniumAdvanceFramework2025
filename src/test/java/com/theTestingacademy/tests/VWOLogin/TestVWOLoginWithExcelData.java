package com.theTestingacademy.tests.VWOLogin;


import com.theTestingacademy.utils.UtilExcelReader;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestVWOLoginWithExcelData {

    @Description("Verify login by extracting data from Excel sheet")
    @Test(dataProvider = "logindata")
    public void testDrivenTest(String email, String password) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(email);
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

        // Add validation steps here if needed

        driver.quit();
    }

    @DataProvider(name = "logindata")
    public Object[][] getData() throws IOException {
        String filePath = "C:\\Users\\rnish\\Development\\workspcae2024\\ATB8XSeleniumAdvanceFramework\\src\\test\\resources\\TestData.xlsx";
        String sheetName = "LoginData";
        return UtilExcelReader.getDataFromExcel(filePath, sheetName);
    }
}
