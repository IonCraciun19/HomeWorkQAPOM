package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindows extends BasePage {

    public MultipleWindows(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="h3")
    WebElement h3;

    public void checkH3Text(String textToFind) {
        String actualText = h3.getText();
        Assertions.assertEquals(textToFind,actualText);
    }

    @FindBy(css="a[href='/windows/new']")
    WebElement clickLink;

    public MultipleWindows switchToNewTab(int index){
        click(clickLink);
        switchToNewWindow(index);
        return this;
    }


    @FindBy(css="div[class='example'] h3")

    WebElement newText;

    public void compareText(String textToFind){
    String actualText = newText.getText();
    Assertions.assertEquals(textToFind, actualText);
    }



}
