package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(css="a[href='/challenging_dom']")
    WebElement challengingDOM;

    public ChallengingDOMPage selectChallengingDOM(){
        click(challengingDOM);
        return new ChallengingDOMPage(driver);
    }
}
