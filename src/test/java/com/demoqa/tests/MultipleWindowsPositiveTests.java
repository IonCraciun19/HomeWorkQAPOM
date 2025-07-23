package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.ChallengingDOMPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.MultipleWindows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MultipleWindowsPositiveTests extends TestBase {

    MultipleWindows multipleWindows;

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectMultipleWindows();
    }

    @Test
    @DisplayName("Click on -'MultipleWindows'")
    public void clickOnMultipleWindowsPositiveTest(){
        new MultipleWindows(driver)
                .checkH3Text("Opening a new window");
    }

    @Test
    public void switchToNevTabPositiveTest(){
        multipleWindows.switchToNewTab(1)
                .compareText("New Window");

    }

}
