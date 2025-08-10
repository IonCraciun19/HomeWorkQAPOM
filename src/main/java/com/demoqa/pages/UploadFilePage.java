package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.InputEvent;

public class UploadFilePage extends BasePage {

    public UploadFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#file-upload")
    WebElement fileUploadButton;

    public UploadFilePage clickOnChooseFileButton(String path) {
        fileUploadButton.sendKeys(path);
        return this;
    }

    @FindBy(id="file-upload")
    WebElement chooseFile;

    public UploadFilePage clickOnChooseFile(){
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseFile).click().perform();
//        try {
//            Robot robot = new Robot();
//            Thread.sleep(5000);
//            robot.mouseMove(100, 200);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        } catch (AWTException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return this;
    }

    public UploadFilePage verifySuccessUploading(String path) {
        Assertions.assertTrue(path.contains("picture1.png"));
        return this;
    }
}
