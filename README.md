# Selenium Automation Framework(with Java)

- Author -Nishi Ravi

- Java, Selenium, TestNG
- Maven, AssertJ, POM
- Thread Local Support → Thread Safety
- Allure Report
- Excel Sheet for Test Data → Data Provider, Apache POI
- Read the username and password from Properties-
- TestNG, @Test, Before and After Method.
- Cloud Grids - BrowserStack, LambdaTest
- SonarLint, Java > 22
- Run Local and on Selenoid Integration.

<img width="1024" alt="Screenshot 2023-10-31 at 12 27 14 PM" src="https://github.com/PramodDutta/AdvanceSeleniumFrameworkTTA/assets/1409610/02b0ef3b-1165-46cf-8c9d-89e41b17032f">


`mvn test -Dsurefire.suiteXmlFiles=VWOtestng.xml` // cmd to run the testng xml 

<img width="1215" alt="Screenshot 2023-10-31 at 12 27 28 PM" src="https://github.com/PramodDutta/AdvanceSeleniumFrameworkTTA/assets/1409610/b0905741-d88d-4559-93c2-65433e668170">

# **Web Automation Framework |. Selenium  Framework**

1. Test Script -> Divided them into the folder Structure.
    1. **main** - dev
        1. base - commonToAll Pages -> This is class which will have all the common pages functionalities
        2. driver -> drivermanager - which will give you the driver
        3. pages
            1. page object model
                1.  pages - loginPage, dashBoardPage....
                2. Page Object Model - 80%
                3. Page Factory (Only use non SPA application)  -> 20%
        4. Utils
            1. PropertiesReader -> read from the data.properties file and give the values based in the key mentioned
                1. Purpose -> no hard code value in the code.
                2. reusability, maintenance, scalability.
            2. ExcelReader -> which can read from the Excel file if we want to do data driven
                1. apache POI for this.
        5.resources Folder
           1. log4j.xml
        
    2. **tests** - test related code
        1. base
            1. Common to All Test Code
                1. BeforeMethods, AfterMethod -> setUp and tearDown
        2.Listeners: To Listen to failed testcases and retry them .
        3.tests
            1. Projectswise
                1. vwo
                    1. TestVWOLogin
                        1. extends from the CommonToAllTest
                            1. We will call the POM Calls and Assertions
                            2. Assertions
                                1. TestNG
                                2. AssertJ
                2. orangeHR
        4. resources Folder
            1. data.properties
            2.TestData.xlsx


   3.**TestNG** xmls
        1. to run the code in QA, Preprod env and Prod.


   4.**pom.xml**->
           1. Dependencies
           2. buil config
   
