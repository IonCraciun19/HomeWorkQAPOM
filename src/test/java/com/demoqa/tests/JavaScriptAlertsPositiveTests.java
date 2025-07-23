package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.JavaScriptAlertsPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JavaScriptAlertsPositiveTests extends TestBase {

    JavaScriptAlertsPage jsAlertPage;

    @BeforeEach
    public void precondition(){
        jsAlertPage = new JavaScriptAlertsPage(driver);
        new HomePage(driver).selectJavaScriptAlerts();
    }

    @Test
    @DisplayName("Click on -'JavaScriptAlerts'")
    public void clickOnJavaScriptAlertsPositiveTest(){
        new JavaScriptAlertsPage(driver)
                .checkH3JSText("JavaScript Alerts");
    }

    @Test
    public void iAmJSAlert(){
        jsAlertPage.verifyJSAlert();
    }

    @Test
    @DisplayName("Verify to 'OK' is displayed")
    public void alertAlertWithOKSelectResultTest(){
        jsAlertPage.selectResult("OK")
                .verifyResult("Ok");
    }

    @Test
    @DisplayName("Verify to 'Cancel' is displayed")
    public void alertAlertWithCancelSelectResultTest(){
        jsAlertPage.selectResult("Cancel")
                .verifyResult("Cancel");
    }

    @Test
    public void sendMessageToAlertText(){
        jsAlertPage.sendMessageToAlert("Hallo Friends!!!")
                .verifyMessage("Hallo Friends!!!");
    }


}
