package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="dropdown")
    WebElement dropdownForm;

    public DropDownPage clickDropdownForm(){
        click(dropdownForm);
        return this;
    }

    public DropDownPage getFormMenu(String option){
        Select select = new Select(dropdownForm);
        select.selectByVisibleText(option);
        return this;
    }

    public DropDownPage verifyOption(){
        String firstOption = new Select(dropdownForm).getFirstSelectedOption().getText();
        Assertions.assertTrue(shouldHaveText(dropdownForm, firstOption,5));
        return this;
    }

}
