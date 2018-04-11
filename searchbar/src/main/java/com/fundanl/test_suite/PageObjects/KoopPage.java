package com.fundanl.test_suite.PageObjects;

import com.fundanl.test_suite.SharedElements;
import com.fundanl.test_suite.SharedGetters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KoopPage  extends SharedGetters {
    final private String URL="https://www.funda.nl/koop/";
    final private String TITLE="Zoek huizen en appartementen te koop in Nederland [funda]";


    WebDriver driver;


    public KoopPage(WebDriver driver){
        this.driver=driver;

    }


    /*GETTERS*/
    public String getURL(){
        return URL;
    }

    public String getRadiusID() {
        return radiusID;
    }

    public String getTITLE(){
        return TITLE;
    }
}
