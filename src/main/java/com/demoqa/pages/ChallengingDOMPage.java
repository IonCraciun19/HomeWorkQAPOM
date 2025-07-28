package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengingDOMPage extends BasePage {

    public ChallengingDOMPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css="h3")
    WebElement h3;

    public void checkH3Text(String textToFind) {
        String actualText = h3.getText();
        Assertions.assertEquals(textToFind,actualText);
    }
}
