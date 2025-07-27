package com.demoqa.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@ExtendWith(TestResultLogger.class)
public class TestBase {

    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    public boolean testPassed = true;

    @BeforeEach
    public void init(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @BeforeEach
    public void startTest(){}

    @AfterEach
    public void stopTest(){
        logger.info("Stop test");
        logger.info("=========================");
    }
}
