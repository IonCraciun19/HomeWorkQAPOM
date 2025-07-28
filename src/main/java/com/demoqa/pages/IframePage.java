package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class IframePage extends BasePage {

    public IframePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css="a[href='/nested_frames']")
    WebElement nestedFrames;

    public IframePage selectNestedFrames(){
        click(nestedFrames);
        return this;
    }

    @FindBy(xpath="/html[1]/frameset[1]")
    List<WebElement> frameSet;

    public IframePage returnListOfFrames(){
        System.out.println("number of frames is " + frameSet.size());
        return this;
    }

    @FindBy(css="body")
    WebElement body1;

    public IframePage switchToIframeById(int index){
        driver.switchTo().frame(body1);
        return this;
    }

    public IframePage switchToTopFrame(){
        driver.switchTo().frame("frame-top");
        return this;
    }

    @FindBy(xpath = "//body[contains(text(), 'LEFT')]")
    WebElement leftText;

    public IframePage switchToLeftFrame(){
        driver.switchTo().frame("frame-left");
        return this;
    }

    public IframePage verifyFrameLeftText(String title){
        Assertions.assertTrue(isContainsTest(title, leftText));
        return this;
    }

    @FindBy(id="content")
    WebElement middleText;

    public IframePage switchToMiddleFrame(){
        driver.switchTo().frame("frame-middle");
        return this;
    }

    public IframePage verifyFrameMiddleText(String middleTitle) {
        Assertions.assertTrue(isContainsTest(middleTitle, middleText));
        return this;
    }

    @FindBy(xpath = "//body[contains(text(), 'RIGHT')]")
    WebElement rightText;

    public IframePage switchToRightFrame(){
        driver.switchTo().frame("frame-right");
        return this;
    }

    public IframePage verifyRightText(String rightTitle){
        Assertions.assertTrue(isContainsTest(rightTitle, rightText));
        return this;
    }

    @FindBy(css="body")
    WebElement body2;
    public IframePage switchToBottomFrame(){
        driver.switchTo().frame("frame-bottom");
        return this;
    }

    public IframePage verifyBottomText(String bottomTile){
        Assertions.assertTrue(isContainsTest(bottomTile, body2));
        return this;
    }
}
