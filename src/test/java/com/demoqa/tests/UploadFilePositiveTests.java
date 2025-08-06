package com.demoqa.tests;

import com.demoqa.core.TestBase;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.UploadFilePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UploadFilePositiveTests extends TestBase {

    HomePage homePage;
    UploadFilePage uploadFile;

    @BeforeEach
    public void precondition(){
        homePage = new HomePage(driver);
        uploadFile = new UploadFilePage(driver);
        homePage.selectUploadFile();
    }

    @Test
    public void uploadNewFile(){
        uploadFile.clickOnChooseFileButton("C:/Tools/picture1.png")
                .verifySuccessUploading("picture1.png")
                ;

    }

}
