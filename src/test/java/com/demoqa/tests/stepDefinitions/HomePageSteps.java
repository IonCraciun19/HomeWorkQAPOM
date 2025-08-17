package com.demoqa.tests.stepDefinitions;

import com.demoqa.core.ApplicationManager;
import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.demoqa.core.BasePage.driver;


public class HomePageSteps {
    
    @Given("User is on the Home Page")
    public void open_home_page(){
        driver = new ApplicationManager("chrome").startTest();
        System.out.println(driver);
        new HomePage(driver).open();
        System.out.println("After Open HomePage");
    }

    @When("User clicks on Form Authentication link")
    public void clicks_on_FormAuthenticationLink(){
        new HomePage(driver).clickOnAuthenticationLink();
    }
}
