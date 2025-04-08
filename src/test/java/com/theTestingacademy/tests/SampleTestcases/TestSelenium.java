package com.theTestingacademy.tests.SampleTestcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.qameta.allure.Description;

public class TestSelenium {

    @Description("Intial Test")
    @Test
    public void verifydryrun()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.quit();
    }
}
