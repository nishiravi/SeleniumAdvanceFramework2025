package com.theTestingacademy.tests.SampleTestcases.DataDerivenTesting;

import io.qameta.allure.Description;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestBasicDataDriverTesting {


    @Description(" Verify login with multi username and password")
    @Test(dataProvider = "LoginTestData")
    public void loginMultiUser(String email,String password)
    {
        System.out.println(email +"|"+password);
    }

    @DataProvider(name="LoginTestData")
    public Object[][] getTestdata() throws IOException {
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\rnish\\Development\\workspcae2024\\ATB8XSeleniumAdvanceFramework\\src\\test\\resources\\TestData.xlsx"));
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sh=wb.getSheet("LoginData");
        int rowcount=sh.getLastRowNum();
        int columncount=sh.getRow(0).getLastCellNum();
        Object[][] data=new Object[rowcount][columncount];
        for(int i=1;i<=rowcount;i++)
        {
            for(int j=0;j<columncount;j++)
            {
                data[i-1][j]=sh.getRow(i).getCell(j).toString();
            }
        }
        return data;
    }


}
