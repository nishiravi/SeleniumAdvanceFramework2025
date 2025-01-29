package com.theTestingacademy.tests.VWOLogin;

import io.qameta.allure.Description;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestVWOLoginMultiData {


    String email;
    String password;
    String id;
    @Description("Verify login by extracting data from excel sheet ")
    @Test(dataProvider = "logindata")
    public void testDrivenTest(String email,String password) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).clear();
        driver.findElement(By.id("login-username")).sendKeys(email);
        driver.findElement(By.id("login-password")).clear();
        driver.findElement(By.id("login-password")).sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();

    }
    @DataProvider(name = "logindata")
    public Object[][] getdatafromExcel() throws IOException {
         Workbook book;
         Sheet sheet;
        FileInputStream fin=new FileInputStream(new File("C:\\Users\\rnish\\Development\\workspcae2024\\ATB8XSeleniumAdvanceFramework\\src\\test\\resources\\TestData.xlsx"));
        book= WorkbookFactory.create(fin);
        sheet=book.getSheet("LoginData");
        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=1;i<=sheet.getLastRowNum();i++)
        {
            for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
            {
                data[i-1][j]=sheet.getRow(i).getCell(j).toString();
            }
        }

        return data;
    }


}
