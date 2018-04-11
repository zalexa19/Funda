package com.fundanl.test_suite.PageObjects;

import org.openqa.selenium.WebDriver;

public class RecreatiePage {
    private final String URL = "https://www.funda.nl/recreatie/";
    final private String TITLE="Zoek recreatiewoningen in Nederland [funda]";

    WebDriver driver;
    public RecreatiePage(WebDriver driver){
        this.driver=driver;

    }

    public String getURL(){
        return URL;
    }
    public String getTITLE(){
        return TITLE;
    }
}
