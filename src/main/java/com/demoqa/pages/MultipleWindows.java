package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

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

    public MultipleWindows selectClickLink(){
        click(clickLink);
        return this;
    }

    public MultipleWindows switchToNewTab(int index){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(css="h3")
    WebElement h3NewTab;
    public MultipleWindows verifyTabTitle(String title){
        shouldHaveText(h3NewTab,title,5);
        return this;
    }
}
