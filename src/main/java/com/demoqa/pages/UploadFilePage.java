package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public UploadFilePage verifySuccessUploading(String path) {
        Assertions.assertTrue(path.contains("picture1.png"));
        return this;
    }
}
