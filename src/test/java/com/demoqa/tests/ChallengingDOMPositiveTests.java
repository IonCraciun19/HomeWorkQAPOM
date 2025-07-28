package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.ChallengingDOMPage;
import com.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChallengingDOMPositiveTests extends TestBase {

    HomePage homePage;
    ChallengingDOMPage challengingDOM;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        challengingDOM = new ChallengingDOMPage(driver);
        homePage.selectChallengingDOM();
    }

    @Test
    @DisplayName("Click on -'ChallengingDOM'")
    public void clickOnChallengingDOMPositiveTest(){
        challengingDOM.checkH3Text("Challenging DOM");
    }
}
