package com.fundanl.test_suite;

import com.fundanl.test_suite.PageObjects.KoopPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import java.io.IOException;

public class Tests extends Base{

    @BeforeClass
    public void initialize(){
        try {
            load_prop_file();
            initialize_driver();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void openPage(){
        KoopPage koopPage = new KoopPage(driver);
        driver.get(koopPage.getURL());

        driver.switchTo().frame(koopPage.getFormElement());

        koopPage.getDistanceFilter().click();

        /*koopPage.getHuurButton().click();*/
/*
       koopPage.getDistanceValues().selectByIndex(2);
*/

    }
}
