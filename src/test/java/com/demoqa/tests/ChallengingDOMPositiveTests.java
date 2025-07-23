package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.ChallengingDOMPage;
import com.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChallengingDOMPositiveTests extends TestBase {

    @BeforeEach
    public void precondition(){
        new HomePage(driver).selectChallengingDOM();
    }

    @Test
    @DisplayName("Click on -'ChallengingDOM'")
    public void clickOnChallengingDOMPositiveTest(){
        new ChallengingDOMPage(driver)
                .checkH3Text("Challenging DOM");
    }
}
