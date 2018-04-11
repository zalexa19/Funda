package com.fundanl.test_suite;

import com.fundanl.test_suite.PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests extends Base implements SharedElements{

    private Select radiusValues,rangeMinValues,rangeMaxValues;
    private WebDriverWait wait;
    private KoopPage koopPage;
    private HuurPage huurPage;
    private NieuwbouwPage nieuwbouwPage;
    private RecreatiePage recreatiePage;
    private EuropaPage europaPage;




    String city="Amsterdam";

    @BeforeSuite
    public void initialize(){

        try {
            load_prop_file();
            initialize_driver();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * This method creates lists from all the drop downs, for later use
     */
    @BeforeClass
    public void createLists(){
        koopPage = new KoopPage(driver);
        huurPage = new HuurPage(driver);
        nieuwbouwPage = new NieuwbouwPage(driver);
        recreatiePage = new RecreatiePage(driver);
        europaPage=new EuropaPage(driver);


        driver.get(koopPage.getURL());

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //time to pass the i'm not a robot


        System.out.println("Creating list for radius");
        radiusValues=new Select(koopPage.getRadius(driver));
        rangeMinValues=new Select(koopPage.getRangeMin(driver));
        rangeMaxValues=new Select(koopPage.getRangeMax(driver));
        wait=new WebDriverWait(driver,10);
    }

    @AfterClass
    public void deleteCookies(){
        driver.manage().deleteAllCookies();

        System.out.println("cookies deleted");

    }

/*

    @Test(enabled = false)
    public void openPage(){


        radiusValues.selectByIndex(2);
        rangeMinValues.selectByValue("225000");
        rangeMaxValues.selectByValue("50000");
        koopPage.getSearchButton().click();

    }

    @Test(priority = 1)
    public void dynamicSearch(){
        String city ="Amsterdam";
        koopPage.getInputField().sendKeys(city);
    }
*/




/* Description: Searches for properties in to buy in Amsterdam, without using any filters
 * Expected: User is able to input "Amsterdam" and press "zoek". Results page is loaded
 */


    /*Desc: These tests make sure that the element is visible.
     *
     */

    @Test(groups = "visibility")
    public void koopTabVisibility(){
        koopPage.getKoopButton(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void huurTabVisibility(){
        koopPage.getHuurButton(driver).isEnabled();
    }


    @Test(groups = "visibility")
    public void nieuwbouwTabVisibility(){
        koopPage.getNiewbiuwButton(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void recreatieTabVisibility(){
        koopPage.getRecreatieButton(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void europaTabVisibility(){
        koopPage.getEuropeButton(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void inputFieldVisibility(){
        koopPage.getInputField(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void radiusFilterVisibility(){
        koopPage.getRadiusFilter(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void vanFilterVisibility(){
        koopPage.getRangeMin(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void totFilterVisibility(){
        koopPage.getRangeMax(driver).isEnabled();
    }

    @Test(groups = "visibility")
    public void searchBttonVisibility(){
        koopPage.getSearchButton(driver).isEnabled();
    }


    /**
     * These tests check the the links for each tab are correct
     */


    @Test(groups="links")
    public void checkHuurTabLink(){
        compareLinks(koopPage.getHuurButton(driver),huurPage.getURL());
    }

    @Test(groups="links")
    public void checKoopTabLink(){
        driver.get(huurPage.getURL());
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        compareLinks(huurPage.getKoopButton(),koopPage.getURL());
    }


    @Test(groups="links")
    public void checkNieuwbouwLink(){
        compareLinks(koopPage.getNiewbiuwButton(driver),nieuwbouwPage.getURL());
    }

    @Test(groups="links")
    public void checkRecreatieLink(){
        compareLinks(koopPage.getRecreatieButton(driver),recreatiePage.getURL());
    }

    @Test(groups="links")
    public void checkEuropeLink(){
        compareLinks(koopPage.getEuropeButton(driver),europaPage.getURL());
    }




    /*titles-these tests check that the page titles are not changed*/
    @Test(groups="titles")
    public void checkKoopPageTitle(){
        koopPage.getHuurButton(driver).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        compareTitles(huurPage.getKoopButton(driver),koopPage.getTITLE());
    }

    @Test(groups="titles")
    public void checkHuurPageTitle(){
        compareTitles(koopPage.getHuurButton(driver),huurPage.getTITLE());
    }


    @Test(groups="titles")
    public void checkNieuwbouwPageTitle(){
        compareTitles(koopPage.getNiewbiuwButton(driver),nieuwbouwPage.getTITLE());
    }

    @Test(groups="titles")
    public void checkRecreatiePageTitle(){
        compareTitles(koopPage.getRecreatieButton(driver),recreatiePage.getTITLE());
    }

    @Test(groups="titles")
    public void checkEuropePageTitle(){
        compareTitles(koopPage.getEuropeButton(driver),europaPage.getTITLE());
    }



    /*Filter values*/

    /**
     * These tests check that the filter values are unchanged
     * These tests create a list of values from the static drop list, and compare the derived values to
     * the expected values in "SharedElements" interface
     */

    @Test(groups="filters")
    public void checkRadiusFilterValues(){
        compareStaticDropDownValues(radiusValues.getOptions(),expectedRadiusFilterValues);
    }


    @Test(groups="filters")
    public void checkRangeMinFilterValues(){
        compareStaticDropDownValues(rangeMinValues.getOptions(),expectedMinRangeValues);

    }


    @Test(groups="filters")
    public void checkRangeMaxFilterValues(){
        compareStaticDropDownValues(rangeMaxValues.getOptions(),expectedMaxRangeValues);

    }





    /*Search field tests*/

    /*This test focues on the clear field button*/


    public void SearchFieldclearInput(){
        koopPage.getInputField(driver).click();
        koopPage.getAutoCompleteClearButton()
    }




    @Test
    public void searchBuyingPropertiesNoFilters(){

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(koopPage.getRadiusID())));

        koopPage.getInputField(driver).sendKeys(city);
        koopPage.getSearchButton(driver).click();

    }

/* Description: This test depends on the previous one, and the search results are checked
 * Expected: All results
 */

    @Test
    public void checkAutoComplete(){
        loadHome();
        koopPage.getInputField(driver).sendKeys(city.substring(3));

    }



    private void loadHome(){
        driver.get(koopPage.getURL());
    }





/***************************************************************/
/**********************PRIVATE_METHODS**************************/
/***************************************************************/




    /*
        This method is reused in each test that compares page links.
        It receives the page for which the check is done, and on which button to press.
        Then, this function is checks if the 2 URLS are the same.
     */
    private void compareLinks(WebElement button, String expectedUrl){
        String actualUrl;

        button.click();

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        actualUrl=driver.getCurrentUrl();
        System.out.println("current: "+actualUrl+", expected: "+expectedUrl);
        Assert.assertEquals(actualUrl,expectedUrl);

    }

    private void compareTitles(WebElement button, String expectedTitle){

        button.click();
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }


    /**
     * This method creates a list from the derived values, loops through it and compares
     * the text to the expected String[]
     * @param actual: represents a list of values derived from the page
     * @param expectedValuesArray: represents the expected values from an array defined in SharedElements
     */
    private void compareStaticDropDownValues(List<WebElement> actual, String[] expectedValuesArray){
        List<WebElement> actualValuesList = actual;
        int size = actualValuesList.size();

        for (int i=0;i<size;i++){
            String actualValue = actualValuesList.get(i).getText();
            String expectedValue = expectedValuesArray[i];
            Assert.assertEquals(actualValue,expectedValue);

        }
    }



    /*Method that creates arrays for the range filters*/
    private String[] createExpectedMinRangeValues(){
        int[] numbers = new int[MAX_ARRAY_SIZE];
        String[] result =new String[MAX_ARRAY_SIZE];
        int addition = 25000;
        int quarters =14;
        int halves=5;
        int index=0;
        String euroSign="€ ";

        result[index++]="Anders";//0

        numbers[index++]=0;//0
        numbers[index++]=50000;//1


        System.out.println("\n\n\n\n\n"+numbers[index-1]);


        for (int i=0;i<quarters;i++){
            System.out.println(numbers[index-1]+addition);
            numbers[index]=numbers[index-1]+addition;
            index++;

        }


        for (int i=0;i<halves;i++){
            numbers[index++]=numbers[index-1]+addition*2;
        }

        for (int i=0; i<3;i++){
            numbers[index++]=numbers[index-1]+addition*4;
        }

        numbers[index++]=numbers[index-1]+addition*20; //1.500.000
        numbers[index++]=numbers[index-1]+addition*20; //2.000.000



        //convert to strings

        for (int i=index;i>1; i--){
            result[index]=Integer.toString(numbers[index]);
            result[index--]=euroSign+result[index];
        }

        return result;
    }



    /*TEMP**/
    public void printList(Select s){
        List<WebElement> list = s.getOptions();

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
        }
        System.out.println("size: "+list.size());
    }
}




