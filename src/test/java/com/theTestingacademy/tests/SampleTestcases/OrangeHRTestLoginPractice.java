package com.theTestingacademy.tests.SampleTestcases;

import com.theTestingacademy.pages.PageObjectModel.VMO.VWOLoginPage_POM;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRTestLoginPractice {
    @Description("Verify with valid credential Login is successful")
    @Owner("Nishi Ravi")
    @Test
    public void testLoginValidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//div[contains(@class,'oxd-input-group')]/div[2]/input")).sendKeys("admin");
        driver.findElement(By.name("username")).sendKeys("admin");
    }
}
