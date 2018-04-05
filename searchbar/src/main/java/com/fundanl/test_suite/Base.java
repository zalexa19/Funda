package com.fundanl.test_suite;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/*
    In this class, The data.properties file is confiugred, and the required driver is initialized.

*/
public class Base {
    final String PATH_VAR = "path"; //Var to derive driver's file location in the data.properties file
    WebDriver driver;
    Properties properties;
    FileInputStream fileInputStream;



    public void load_prop_file() throws IOException{
        properties = new Properties();
        fileInputStream = new FileInputStream("/home/alexz/Desktop/GitHub/Funda/searchbar/src/main/java/data.properties");
        properties.load(fileInputStream);
    }


    public void initialize_driver() throws IOException{
        String browser;
        String browser_path;



        browser=properties.getProperty("browser");

        if (browser.equals("chrome")){
            browser_path=properties.getProperty("chrome_path");
            System.setProperty("webdriver.chrome.driver",browser_path);
            driver=new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            browser_path=properties.getProperty("firefox_path");

            System.setProperty("webdriver.gecko.driver",browser_path);
            driver=new FirefoxDriver();
        }

        else if(browser.equals("IE")){
            browser_path=properties.getProperty("IE_path");
            System.setProperty("webdriver.ie.driver",browser_path);
            driver=new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


}
