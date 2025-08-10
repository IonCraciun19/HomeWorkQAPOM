package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.JavaScriptAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class JavaScriptAlertsPositiveTests extends TestBase {

    HomePage homePage;
    JavaScriptAlertsPage jsAlertPage;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        jsAlertPage = new JavaScriptAlertsPage(driver);
        homePage.selectJavaScriptAlerts();
    }

    @Test
    @DisplayName("Click on -'JavaScriptAlerts'")
    @Tag("smoky")
    public void clickOnJavaScriptAlertsPositiveTest(){
        jsAlertPage.checkH3JSText("JavaScript Alerts");
    }

    @Test
    @Tag("smoky")
    public void iAmJSAlert(){
        jsAlertPage.verifyJSAlert();
    }

    @Test
    @DisplayName("Verify to 'OK' is displayed")
    @Tag("smoky")
    public void alertAlertWithOKSelectResultTest(){
        jsAlertPage.selectResult("OK")
                .verifyResult("Ok");
    }

    @Test
    @DisplayName("Verify to 'Cancel' is displayed")
    @Tag("smoky")
    public void alertAlertWithCancelSelectResultTest(){
        jsAlertPage.selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    @Tag("smoky")
    public void sendMessageToAlertText(){
        jsAlertPage.sendMessageToAlert("Hallo Friends!!!")
                .verifyMessage("Hallo Friends!!!");
    }
}
