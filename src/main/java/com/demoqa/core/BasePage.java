package com.demoqa.core;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void click(WebElement element){
        element.click();
    }

    public WebDriverWait wait(int time) {
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public void type(WebElement element, String text){
        if (text !=null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    public boolean isAlertPresent(int time){
        Alert alert = wait(time)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        }
        alert.accept();
        return true;
    }

    public boolean shouldHaveText(WebElement element, String text, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        boolean isTextPresent = wait
                .until(ExpectedConditions.textToBePresentInElement(element, text));
        Assertions.assertTrue(isTextPresent);
        return isTextPresent;
    }

    protected boolean isContainsTest(String userName, WebElement element) {
        return element.getText().contains(userName);
    }
}
