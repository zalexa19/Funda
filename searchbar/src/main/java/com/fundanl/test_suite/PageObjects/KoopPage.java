package com.fundanl.test_suite.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KoopPage {
    final private String URL="https://www.funda.nl";
    private String radiusID="Straal";
    WebDriver driver;


    public KoopPage(WebDriver driver){
        this.driver=driver;

    }


    /*Buttons*/
    By koopButton= By.cssSelector("a[href*koop]");
    By huurButton = By.cssSelector("a[href*=huur]");
    By niewbouwButton=By.cssSelector("a[href*=nieuwbouw]");
    By recreatieButton=By.cssSelector("a[href*=recreatie]");
    By europeButton=By.cssSelector("a[href*=europe]");
    By searchButton=By.cssSelector("button.button-primary-alternative");

    /*filters*/
    By radiusFilter = By.xpath("//fieldset[@class='search-block__location-filters']/div[2]/select");
    By radius = By.id(radiusID);
    By rangeMin=By.id("range-filter-selector-select-filter_koopprijsvan");
    By rangeMax=By.id("range-filter-selector-select-filter_koopprijstot");
    By inputField=By.id("autocomplete-input");


    public WebElement getInputField(){
        return driver.findElement(inputField);
    }


    public WebElement getRadius(){
        return driver.findElement(radius);
    }





    /**********************************************/



    public WebElement getKoopButton(){
        return driver.findElement(koopButton);
    }


    public WebElement getHuurButton(){
        return driver.findElement(huurButton);
    }

    public WebElement getNiewbiuwButton(){
        return driver.findElement(niewbouwButton);
    }

    public WebElement getRecreatieButton(){
        return driver.findElement(recreatieButton);
    }

    public WebElement getEuropeButton(){
        return driver.findElement(europeButton);
    }

    public WebElement getSearchButton(){
        return driver.findElement(searchButton);
    }



    public WebElement getRadiusFilter(){
        return driver.findElement(radiusFilter);
    }

    public WebElement getRangeMin(){
        return driver.findElement(rangeMin);
    }

    public WebElement getRangeMax(){
        return driver.findElement(rangeMax);
    }



    /*GETTERS*/
    public String getURL(){
        return URL;
    }

    public String getRadiusID() {
        return radiusID;
    }
}
