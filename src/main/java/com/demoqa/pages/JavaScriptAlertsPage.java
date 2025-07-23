package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage {

    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="h3")
    WebElement h3;

    public void checkH3JSText(String textToFind) {
        String actualText = h3.getText();
        Assertions.assertEquals(textToFind,actualText);
    }

    @FindBy(css="button[onclick='jsAlert()']")
    WebElement jsAlert;

    public JavaScriptAlertsPage verifyJSAlert(){
        click(jsAlert);
        Assertions.assertTrue(isAlertPresent(5));
        return this;
    }

    @FindBy(css="button[onclick='jsConfirm()']")
    WebElement jsConfirm;

    public JavaScriptAlertsPage selectResult(String result){
        click(jsConfirm);
        if (result != null && result.equals("OK")){
            driver.switchTo().alert().accept();
        }else if (result != null && result.equals("Cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id="result")
    WebElement result;

    public JavaScriptAlertsPage verifyResult(String text){
        Assertions.assertTrue(shouldHaveText(result, text,10));
        return this;
    }

    @FindBy(css="button[onclick='jsPrompt()']")
    WebElement jsPrompt;

    public JavaScriptAlertsPage sendMessageToAlert(String message){
        click(jsPrompt);
        if (message !=null){
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(css="#result")
    WebElement promptResult;

    public JavaScriptAlertsPage verifyMessage(String text){
        Assertions.assertTrue(shouldHaveText(promptResult, text, 10));
        return this;
    }

}