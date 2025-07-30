package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.DragAndDropPage;
import com.demoqa.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DragAndDropPositiveTests extends TestBase {

    HomePage homePage;
    DragAndDropPage dragAndDrop;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        dragAndDrop = new DragAndDropPage(driver);
        homePage.selectDragAndDrop();
    }

    @Test
    public void actionDragMeATest(){
        dragAndDrop.actionDragMe()
                .verify1Dropped("A");
    }

    @Test
    public void actionDragMeBTest(){
        dragAndDrop.actionDragMe()
                .verify2Dropped("B");
    }

}
