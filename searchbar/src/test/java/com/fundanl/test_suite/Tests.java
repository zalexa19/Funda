package com.fundanl.test_suite;

import com.fundanl.test_suite.PageObjects.KoopPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tests extends Base{
    private Select radiusValues,rangeMinValues,rangeMaxValues;
    private KoopPage koopPage;

    @BeforeSuite
    public void initialize(){
        try {
            load_prop_file();
            initialize_driver();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method creates lists from all the drop downs, for later use
     */
    @BeforeClass
    public void createLists(){
        koopPage = new KoopPage(driver);

        driver.get(koopPage.getURL());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //time to pass the i'm not a robot

        System.out.println("Creating list for radius");
        radiusValues=new Select(koopPage.getRadiusId());
        rangeMinValues=new Select(koopPage.getRangeMin());
        rangeMaxValues=new Select(koopPage.getRangeMax());
    }


    @Test(enabled = false)
    public void openPage(){

        //By radiusCSS = By.id("Straal");
        //Select list = new Select(driver.findElement(radiusCSS));
        radiusValues.selectByIndex(2);
        rangeMinValues.selectByValue("225000");
        rangeMaxValues.selectByValue("50000");
        koopPage.getSearchButton().click();

    }

    @Test(priority = 1)
    public void dynamicSearch(){
        String city ="Amsterdam";
        koopPage.getInputField().sendKeys(city);
    }
}
