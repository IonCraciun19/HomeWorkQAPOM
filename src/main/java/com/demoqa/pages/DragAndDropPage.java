package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage {

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#column-a")
    WebElement elementA;
    @FindBy(id="column-b")
    WebElement elementB;

    public DragAndDropPage actionDragMe() {
        wait(1000);

        actions.dragAndDrop(elementA, elementB).perform();
        return this;
    }

    public DragAndDropPage verify1Dropped(String text) {
        Assertions.assertTrue(isContainsTest(text,elementB));
        return this;
    }

    public DragAndDropPage verify2Dropped(String text) {
        Assertions.assertTrue(isContainsTest(text,elementA));
        return this;
    }
}
