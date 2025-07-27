package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.DropDownPage;
import com.demoqa.pages.HomePage;
import org.junit.jupiter.api.Test;

public class DropdownListPositiveTests extends TestBase {

    @Test
    public void selectOption1PositiveTest(){
        new HomePage(driver).selectDropdown();
        new DropDownPage(driver).clickDropdownForm()
                .getFormMenu("Option 1")
                .verifyOption();
    }

    @Test
    public void selectOption2PositiveTeas(){
        new HomePage(driver).selectDropdown();
        new DropDownPage(driver).clickDropdownForm()
                .getFormMenu("Option 2")
                .verifyOption();
    }
}

