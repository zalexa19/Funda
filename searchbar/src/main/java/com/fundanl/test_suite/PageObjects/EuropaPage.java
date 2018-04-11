package com.fundanl.test_suite.PageObjects;

import org.openqa.selenium.WebDriver;

public class EuropaPage {
    private final String URL = "https://www.funda.nl/europe/";
    final private String TITLE="Zoek huizen en appartementen in Europa [funda]";

    WebDriver driver;

    public EuropaPage(WebDriver driver){
        this.driver=driver;

    }


    public String getURL(){
        return URL;
    }
    public String getTITLE(){
        return TITLE;
    }
}
