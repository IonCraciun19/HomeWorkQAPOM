package com.demoqa.pages;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="img")
    List<WebElement> images;

    public BrokenImagesPage ceckBrokenImages() {
        System.out.println("Total size on the page is:  " + images.size());

        for (int i=0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean)js.executeScript
                        ( "return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);",image);

                if (imageDisplayed){
                    softly.assertThat(imageDisplayed);

                } else {
                    softly.fail("Broken image is: " + imageUrl);
                }
            } catch (Exception e) {
                System.out.println("ERROR occurred");
            }

        }
        softly.assertAll();
        return this;
    }


}
