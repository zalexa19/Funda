package com.fundanl.test_suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SharedGetters implements SharedElements {


    public WebElement getInputField(WebDriver driver){
        return driver.findElement(inputField);
    }


    public WebElement getRadius(WebDriver driver){
        return driver.findElement(radius);
    }





    /**********************************************/



    public WebElement getKoopButton(WebDriver driver){
        return driver.findElement(koopButton);
    }


    public WebElement getHuurButton(WebDriver driver){
        return driver.findElement(huurButton);
    }

    public WebElement getNiewbiuwButton(WebDriver driver){
        return driver.findElement(niewbouwButton);
    }

    public WebElement getRecreatieButton(WebDriver driver){
        return driver.findElement(recreatieButton);
    }

    public WebElement getEuropeButton(WebDriver driver){
        return driver.findElement(europeButton);
    }

    public WebElement getSearchButton(WebDriver driver){
        return driver.findElement(searchButton);
    }

    public By getRadius(){
        return radius;
    }

    public WebElement getRadiusFilter(WebDriver driver){
        return driver.findElement(radiusFilter);
    }

    public WebElement getRangeMin(WebDriver driver){
        return driver.findElement(rangeMin);
    }

    public WebElement getRangeMax(WebDriver driver){
        return driver.findElement(rangeMax);
    }

    public WebElement getAutoCompleteClearButton(WebDriver driver){
        return driver.findElement(autoCompleteClearButton);
    }


}
