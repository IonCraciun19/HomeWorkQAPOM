package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.HorizontalSliderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HorizontalSliderTests extends TestBase {

    HomePage homePage;
    HorizontalSliderPage horizontalSlider;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        horizontalSlider = new HorizontalSliderPage(driver);
        homePage.selectHorizontalSlider();
    }

    @Test
    public void sliderTest(){
        horizontalSlider.selectSlider()
                .moveSliderInHorizontalDirection()
                .verifySliderValue("5");
    }
}
