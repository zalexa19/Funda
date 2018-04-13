package com.fundanl.test_suite.PageObjects;

import com.fundanl.test_suite.SharedGetters;
import org.openqa.selenium.WebDriver;

public class Results extends SharedGetters {
    private final String URL_WHEN_EMPTY="https://www.funda.nl/koop/heel-nederland/";
    WebDriver driver;






    public Results(WebDriver driver){
        this.driver=driver;

    }


    public String getURL_WHEN_EMPTY(){
        return URL_WHEN_EMPTY;
    }


}
