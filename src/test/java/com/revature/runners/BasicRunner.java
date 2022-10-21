package com.revature.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// The runner class "ties" the feature files with the step implementation classes that actually contain the automation
// code
@CucumberOptions(features = "classpath:features", glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    @BeforeMethod // This method will run before each Cucumber scenario
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
    }

    @AfterMethod // This method will run after each Cucumber scenario
    public void cleanup() {
        driver.quit();
    }

}
