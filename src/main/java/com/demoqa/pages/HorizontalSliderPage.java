package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.devtools.v137.debugger.Debugger.pause;

public class HorizontalSliderPage extends BasePage {

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//input")
    WebElement slider;

    public HorizontalSliderPage selectSlider() {
        click(slider);
        return new HorizontalSliderPage(driver);
    }

    public HorizontalSliderPage moveSliderInHorizontalDirection() {
       actions.dragAndDropBy(slider, 70,0).perform();
       return this;
    }

    @FindBy(id="range")
    WebElement sliderValue;

    public HorizontalSliderPage verifySliderValue(String number) {
        Assertions.assertEquals(number,sliderValue.getText());
        return this;
    }
}