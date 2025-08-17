package com.demoqa.tests.stepDefinitions;

import com.demoqa.pages.FormAuthenticationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.demoqa.core.BasePage.driver;

public class LoginSteps {

    @And("User enters proposed data")
    public void enters_proposed_data(){
        new FormAuthenticationPage(driver).enterData();
    }

    @And("User clicks on Login button")
    public void click_on_Login_button(){
        new FormAuthenticationPage(driver).clickOnLoginButton();
    }

    @Then("User verifies Success message is displayed")
    public void verify_Success_message(){
        new FormAuthenticationPage(driver).verifyMessage("You logged into a secure area!");
    }
}
