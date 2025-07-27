package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.IframePage;
import com.demoqa.pages.MultipleWindows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrameWindowsTests extends TestBase {

    IframePage iframe;
    HomePage homePage;

    @Test
    public void switchNestedFrameLeftPositiveTest(){
        new IframePage(driver).selectNestedFrames()
                .switchToTopFrame()
                .switchToLeftFrame()
                .verifyFrameLeftText("LEFT");
    }

    @Test
    public void switchNestedFrameMiddlePositiveTest(){
        new IframePage(driver).selectNestedFrames()
                .switchToTopFrame()
                .switchToMiddleFrame()
                .verifyFrameMiddleText("MIDDLE");
    }

    @Test
    public void switchNestedFrameRightPositiveTest(){
        new IframePage(driver).selectNestedFrames()
                .switchToTopFrame()
                .switchToRightFrame()
                .verifyRightText("RIGHT");
    }

    @Test
    public void switchNestedFrameBottomPositiveTest(){
        new IframePage(driver).selectNestedFrames()
                .switchToBottomFrame()
                .verifyBottomText("BOTTOM");
    }

}

