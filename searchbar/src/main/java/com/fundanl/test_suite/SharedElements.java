package com.fundanl.test_suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*This interface includes all the elements that are used by more than 1 class*/
public interface SharedElements {
    final int MAX_ARRAY_SIZE=30;

    String radiusID = "Straal";
    String[] expectedRadiusFilterValues = {
            "+ 0 km",
            "+ 1 km",
            "+ 2 km",
            "+ 5 km",
            "+ 10 km",
            "+ 15 km"
    };

    String[] expectedMinRangeValues={
            "Anders",
            "€ 0",
            "€ 50.000",
            "€ 75.000",
            "€ 100.000",
            "€ 125.000",
            "€ 150.000",
            "€ 175.000",
            "€ 200.000",
            "€ 225.000",
            "€ 250.000",
            "€ 275.000",
            "€ 300.000",
            "€ 325.000",
            "€ 350.000",
            "€ 375.000",
            "€ 400.000",
            "€ 450.000",
            "€ 500.000",
            "€ 550.000",
            "€ 600.000",
            "€ 650.000",
            "€ 700.000",
            "€ 750.000",
            "€ 800.000",
            "€ 900.000",
            "€ 1.000.000",
            "€ 1.250.000",
            "€ 1.500.000",
            "€ 2.000.000"
    };


    String[] expectedMaxRangeValues={
            "Anders",
            "€ 50.000",
            "€ 75.000",
            "€ 100.000",
            "€ 125.000",
            "€ 150.000",
            "€ 175.000",
            "€ 200.000",
            "€ 225.000",
            "€ 250.000",
            "€ 275.000",
            "€ 300.000",
            "€ 325.000",
            "€ 350.000",
            "€ 375.000",
            "€ 400.000",
            "€ 450.000",
            "€ 500.000",
            "€ 550.000",
            "€ 600.000",
            "€ 650.000",
            "€ 700.000",
            "€ 750.000",
            "€ 800.000",
            "€ 900.000",
            "€ 1.000.000",
            "€ 1.250.000",
            "€ 1.500.000",
            "€ 2.000.000",
            "Geen maximum"
    };

    String[] extepctedRangeMaxValues=null;





    /*Buttons*/
    By koopButton = By.cssSelector("a[href*=koop]");
    By huurButton = By.cssSelector("a[href*=huur]");
    By niewbouwButton = By.cssSelector("a[href*=nieuwbouw]");
    By recreatieButton = By.cssSelector("a[href*=recreatie]");
    By europeButton = By.cssSelector("a[href*=europe]");
    By searchButton = By.cssSelector("button.button-primary-alternative");

    /*filters*/
    By radiusFilter = By.xpath("//fieldset[@class='search-block__location-filters']/div[2]/select");
    By radius = By.id(radiusID);
    By rangeMin = By.id("range-filter-selector-select-filter_koopprijsvan");
    By rangeMax = By.id("range-filter-selector-select-filter_koopprijstot");
    By inputField = By.id("autocomplete-input");
    By autoCompleteClearButton = By.cssSelector(".autocomplete-clear");





}
