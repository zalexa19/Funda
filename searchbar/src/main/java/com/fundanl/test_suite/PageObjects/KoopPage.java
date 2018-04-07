package com.fundanl.test_suite.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class KoopPage {
    final private String URL="https://www.funda.nl";
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
    By searchButton=By.className("button-primary-alternative");

    /*filters*/
    By radiusFilter = By.xpath("//fieldset[@class='search-block__location-filters']/div[2]/select");
    By radiusId = By.id("Straal");
    By rangeMin=By.id("range-filter-selector-select-filter_koopprijsvan");
    By rangeMax=By.id("range-filter-selector-select-filter_koopprijstot");
    By inputField=By.id("autocomplete-input");


    public WebElement getInputField(){
        return driver.findElement(inputField);
    }


    public WebElement getRadiusId(){
        return driver.findElement(radiusId);
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





}
