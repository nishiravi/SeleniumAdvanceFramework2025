package com.theTestingacademy.base;

import com.theTestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommanToAllTest {

    @BeforeMethod
    public void setUp()
    {
        DriverManager.init();
    }

    @AfterMethod
    public void teardown()
    {
        DriverManager.down();
    }
}
