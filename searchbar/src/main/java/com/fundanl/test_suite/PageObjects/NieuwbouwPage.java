package com.fundanl.test_suite.PageObjects;

import com.fundanl.test_suite.SharedGetters;
import org.openqa.selenium.WebDriver;

public class NieuwbouwPage extends SharedGetters {
    private final String URL = "https://www.funda.nl/nieuwbouw/";
    final private String TITLE="Zoek nieuwbouwprojecten en -woningen in Nederland [funda]";

    WebDriver driver;

    public NieuwbouwPage(WebDriver driver){
        this.driver=driver;

    }


    public String getURL(){
        return URL;
    }
    public String getTITLE(){
        return TITLE;
    }
}
