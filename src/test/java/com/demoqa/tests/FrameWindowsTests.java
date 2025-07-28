package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.IframePage;
import com.demoqa.pages.MultipleWindows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FrameWindowsTests extends TestBase {

    IframePage iframe;
    HomePage homePage;

    @BeforeEach
    public void precondition(){
        iframe = new IframePage(driver);
        iframe.selectNestedFrames();
    }

    @Test
    public void switchNestedFrameLeftPositiveTest(){
        iframe.switchToTopFrame()
                .switchToLeftFrame()
                .verifyFrameLeftText("LEFT");
    }

    @Test
    public void switchNestedFrameMiddlePositiveTest(){
        iframe.switchToTopFrame()
                .switchToMiddleFrame()
                .verifyFrameMiddleText("MIDDLE");
    }

    @Test
    public void switchNestedFrameRightPositiveTest(){
        iframe.switchToTopFrame()
                .switchToRightFrame()
                .verifyRightText("RIGHT");
    }

    @Test
    public void switchNestedFrameBottomPositiveTest(){
        iframe.switchToBottomFrame()
                .verifyBottomText("BOTTOM");
    }
}

