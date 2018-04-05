package com.fundanl.test_suite.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    By searchField=By.id("autocomplete-input");
    By distanceFilter = By.id("Straal");
    By rangeFromFilter= By.id("range-filter-selector-select-filter_koopprijsvan");
    By rangeToFilter=By.id("range-filter-selector-select-filter_koopprijstot");

    /*form*/
    By formElement=By.cssSelector("form.search-block__form");

    WebElement distanceFilterElement = driver.findElement(distanceFilter);


    Select distanceValues = new Select(distanceFilterElement);
    Select ranfgeFromValues = new Select(getRangeFromFilter());
    Select rangeToValues = new Select(getRangeToFilter());





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

    public WebElement getSearchField(){
        return driver.findElement(searchField);
    }


    public WebElement getDistanceFilter(){
        return driver.findElement(distanceFilter);
    }

    public WebElement getRangeFromFilter(){
        return driver.findElement(rangeFromFilter);
    }

    public WebElement getRangeToFilter(){
        return driver.findElement(rangeToFilter);
    }

    public WebElement getFormElement(){
        return driver.findElement(formElement);
    }

    /*GETTERS*/
    public String getURL(){
        return URL;
    }


    public Select getDistanceValues(){
        return distanceValues;
    }

    public Select getRangeFromValues(){
        return ranfgeFromValues;
    }

    public Select getRangeToValues(){
        return rangeToValues;
    }


}
