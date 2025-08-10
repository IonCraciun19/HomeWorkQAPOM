package com.demoqa.core;

import com.demoqa.utils.TestResultLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@ExtendWith(TestResultLogger.class)
public class TestBase {
    
    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));

    protected WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);
    

    @BeforeEach
    public void init(TestInfo info){
        driver = app.startTest();
        logger.info("Start test {}",info.getDisplayName());
    }


    @AfterEach
    public void tearDown(){
        app.stopTest();
        logger.info("Stop test");
        logger.info("=========================");

    }
}
