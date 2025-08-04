package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.BrokenImagesPage;
import com.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BrokenImagesPositiveTests extends TestBase {

    HomePage homePage;
    BrokenImagesPage brokenImages;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        brokenImages = new BrokenImagesPage(driver);
        homePage.selectBrokenImage();
    }

    @Test
    public void checkBrokenImages(){
        brokenImages.ceckBrokenImages();
    }
}
