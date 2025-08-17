package com.demoqa.core;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

public class BasePage {

    public static WebDriver driver;
    public static Actions actions;
    public static JavascriptExecutor js;
    public static  SoftAssertions softly;

    public BasePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
        softly = new SoftAssertions();
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

    public void verifyLinks(String url) {
        try {
            URL linkUrl=new URL(url);
            HttpURLConnection connection=(HttpURLConnection) linkUrl.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                softly.fail(url + " - " + connection.getResponseMessage() + " is a broken link");
            } else {
                softly.assertThat(connection.getResponseCode()).isLessThan(400);
            }
        } catch (Exception e) {
            System.out.println(url + " - " + e.getMessage() + " ERROR occurred");;
        }
        softly.assertAll();
    }
    
}
