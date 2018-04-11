package com.fundanl.test_suite.PageObjects;

import com.fundanl.test_suite.SharedGetters;
import org.openqa.selenium.*;

public class HuurPage extends SharedGetters {
    final private String URL="https://www.funda.nl/huur/";
    final private String TITLE="Zoek huizen en appartementen te huur in Nederland [funda]";

    private WebDriver driver;

    public HuurPage(WebDriver driver){
        this.driver = driver;
    }


    By koopButton= By.cssSelector("a[href*=koop]");


    public WebElement getKoopButton(){
        return driver.findElement(koopButton);
    }


    public String getURL(){
        return URL;
    }
    public String getTITLE(){
        return TITLE;
    }
}
