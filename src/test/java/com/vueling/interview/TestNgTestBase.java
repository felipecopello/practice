package com.vueling.interview;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNgTestBase {

    protected WebDriver driver;

    @BeforeSuite
    public void initTestSuite() throws IOException {
	System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	driver = new ChromeDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
	driver.quit();
    }
}
