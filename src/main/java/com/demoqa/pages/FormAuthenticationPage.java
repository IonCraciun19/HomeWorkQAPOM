package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormAuthenticationPage extends BasePage {

    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//em[normalize-space()='tomsmith']")
    WebElement userName;
    @FindBy(xpath="//em[normalize-space()='SuperSecretPassword!']")
    WebElement userPassword;
    @FindBy(id="username")
    WebElement inputName;
    @FindBy(id="password")
    WebElement inputPassword;

    public FormAuthenticationPage enterData() {
        String copiedName = userName.getText();
        String copiedPassword = userPassword.getText();
        click(inputName);
        inputName.sendKeys(copiedName);
        click(inputPassword);
        inputPassword.sendKeys(copiedPassword);
        return this;
    }

    @FindBy(css=".radius")
    WebElement button;

    public FormAuthenticationPage clickOnLoginButton() {
        click(button);
        return this;
    }

    @FindBy(id="flash")
    WebElement message;

    public FormAuthenticationPage verifyMessage(String success) {
        Assertions.assertTrue(isContainsTest(success, message));
        return this;
    }

    @FindBy(css="[href='/logout']")
    WebElement logoutButton;

    public FormAuthenticationPage clickOnLogoutButton() {
        click(logoutButton);
        return this;
    }
}