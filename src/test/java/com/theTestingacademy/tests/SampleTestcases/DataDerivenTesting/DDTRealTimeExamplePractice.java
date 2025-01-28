package com.theTestingacademy.tests.SampleTestcases.DataDerivenTesting;

import io.qameta.allure.Description;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DDTRealTimeExamplePractice {


    String email;
    String password;
    String id;
    String expectedresult;
    @Description("Verify login by extracting data from excel sheet ")
    @Test(dataProvider = "logindata")
    public void testDrivenTest(String email,String password,String expectedresult)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("login-username")).sendKeys(email);
        driver.findElement(By.id("login-password")).sendKeys(password);
        driver.findElement(By.id("js-login-btn")).click();
        if(expectedresult.equalsIgnoreCase("Valid"))
        {
            String text=driver.findElement(By.id("locator of the successful text message to be written here ")).getText();
            System.out.println(" success msg is  "+text);
            Assert.assertEquals(text,"expected success msg to be given here");
        }
        if(expectedresult.equalsIgnoreCase("InValid"))
        {
            String errortext=driver.findElement(By.id("locator of the error message to be written here ")).getText();
            System.out.println(" error msg is  "+errortext);
            Assert.assertEquals(errortext,"expected error msg to be given here");
        }

    }

    @DataProvider(name="logindata")
    public Object[][] getDataFromExcel() throws IOException, FileNotFoundException {
        FileInputStream fis = new FileInputStream(new File("Sample_Data.xlsx"));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount - 1][colCount - 1]; // Exclude header row

        for (int i = 1; i < rowCount; i++) { // Start from row 1 (skip header)
            Row row = sheet.getRow(i);
            for (int j = 1; j < colCount; j++) { // Start from column 1 (skip ID)
                Cell cell = row.getCell(j);
                data[i-1][j] = cell.toString();
            }
        }

        workbook.close();
        fis.close();
        return data;
    }
}
