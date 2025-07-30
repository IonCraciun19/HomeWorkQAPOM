package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(css="a[href='/challenging_dom']")
    WebElement challengingDOM;

    public ChallengingDOMPage selectChallengingDOM(){
        click(challengingDOM);
        return new ChallengingDOMPage(driver);
    }

    @FindBy(css="a[href='/javascript_alerts']")
    WebElement jsAlerts;

    public JavaScriptAlertsPage selectJavaScriptAlerts(){
        click(jsAlerts);
        return new JavaScriptAlertsPage(driver);
    }

    @FindBy(css="a[href='/windows']")
    WebElement windows;

    public MultipleWindows selectMultipleWindows(){
        click(windows);
        return new MultipleWindows(driver);
    }

    @FindBy(css="a[href='/nested_frames']")
    WebElement nestedFrame;

    public IframePage selectNestedFrame(){
        click(nestedFrame);
        return new IframePage(driver);
    }

    @FindBy(css="a[href='/dropdown']")
    WebElement dropdown;

    public DropDownPage selectDropdown(){
        click(dropdown);
        return new DropDownPage(driver);
    }

    @FindBy(css="a[href='/drag_and_drop']")
    WebElement dragAndDrop;

    public DragAndDropPage selectDragAndDrop() {
        click(dragAndDrop);
        return new DragAndDropPage(driver);
    }

    @FindBy(css="a[href='/horizontal_slider']")
    WebElement horizontalSlider;

    public HorizontalSliderPage selectHorizontalSlider() {
        click(horizontalSlider);
        return new HorizontalSliderPage(driver);
    }
}