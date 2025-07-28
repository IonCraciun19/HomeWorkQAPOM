package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.DropDownPage;
import com.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DropdownListPositiveTests extends TestBase {

    HomePage homePage;
    DropDownPage dropDown;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        dropDown = new DropDownPage(driver);
        homePage.selectDropdown();
    }

    @Test
    public void selectOption1PositiveTest(){
        dropDown.clickDropdownForm()
                .getFormMenu("Option 1")
                .verifyOption();
    }

    @Test
    public void selectOption2PositiveTeas(){
        dropDown.clickDropdownForm()
                .getFormMenu("Option 2")
                .verifyOption();
    }
}

