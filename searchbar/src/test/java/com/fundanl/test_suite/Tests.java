package com.fundanl.test_suite;

import com.fundanl.test_suite.PageObjects.*;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tests extends Base implements SharedElements{

    private final String EMPTY="";
    private Select radiusValues,rangeMinValues,rangeMaxValues;
    private WebDriverWait wait;
    private KoopPage koopPage;
    private HuurPage huurPage;
    private NieuwbouwPage nieuwbouwPage;
    private RecreatiePage recreatiePage;
    private EuropaPage europaPage;
    private Results resultsPage;




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
        resultsPage = new Results(driver);


        driver.get(koopPage.getURL());

        System.out.println("Creating list for radius");
        radiusValues=new Select(koopPage.getRadius(driver));
        rangeMinValues=new Select(koopPage.getRangeMin(driver));
        rangeMaxValues=new Select(koopPage.getRangeMax(driver));
        wait=new WebDriverWait(driver,10);
    }

    @AfterClass
    public void deleteCookies(){
        driver.manage().deleteAllCookies();

    }





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




    /*These tests check that user is able to input values into "Anders" field*/
    /*************************************************************************/


    /**
     *     This test checks that a "valid" number can be used in the "van" price field.
     */

    @Test(dependsOnMethods = "checkRangeMinFilterValues")
    public void vanFieldEnterValidChars(){ ;
        enterCharsIntoFilter(rangeMinValues,koopPage.getVanFilterAnders(driver),"103");
        koopPage.getSearchButton(driver).click();
    }


    /**
     *  In this test, invalid numbers are inserted.
     *  Expected result: The values should be ignore, the result page should indicate that no filters were applied
     */
    @Test (dependsOnMethods = "checkRangeMinFilterValues")
    public void vanFieldEnterInvalidChars(){
        enterCharsIntoFilter(rangeMinValues,koopPage.getVanFilterAnders(driver),"Text");
        koopPage.getSearchButton(driver).click();

        //new page is loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(filterCounter));
        compareFilterCounterOnResutlsPage(0,driver.findElement(filterCounter).getText());

    }


    /**
     * In this test we make sure that the field has a maximum length
     */
    @Test (dependsOnMethods = "checkRangeMinFilterValues")
    public void vanInputCheckMaxLength(){
        enterCharsIntoFilter(rangeMinValues,koopPage.getVanFilterAnders(driver),"999999991");
    }




    /**
     * This test makes sure that when "Anders" is selected and user inputes no values, "0" is placed
     */
    @Test (dependsOnMethods = "checkRangeMinFilterValues")
    public void vanInputCheckMinLength(){

    }


    /**
     * This test make sure that user is able to use the arrow to increase, decrease the amount
     */
    @Test (dependsOnMethods = "checkRangeMinFilterValues")
    public void vanFieldUseArrows(){
        rangeMinValues.selectByIndex(0);

    }


    /**
     * These tests are the same tests as for "van" filter, only applied on "tot".
     */
    @Test (dependsOnMethods = "checkRangeMaxFilterValues")
    public void totFieldEnterValidChars(){

    }

    @Test (dependsOnMethods = "checkRangeMaxFilterValues")
    public void totFieldEnterInvalidChars(){

    }


    @Test (dependsOnMethods = "checkRangeMaxFilterValues")
    private void insertValidChars(){

    }




    /*Search field tests*/


    /**
     * clear field button should not appear if user didn't insert any values into the search bar
     */

    @Test(groups="search_field")
    public void searchFieldNoClearButton(){
        koopPage.getInputField(driver).click();

        boolean result = isElementPresent(koopPage.getautoCompleteLightGray(driver));
        Assert.assertEquals(false,result);
    }


    /*
    * Auto clear button appears when the field is not empty
    *
    * */

    @Test(groups = "search_field")
    public void searchFieldClearButtonAppears(){
        koopPage.getInputField(driver).sendKeys(city);

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        koopPage.getAutoCompleteClearButton(driver).click();
        String inputResult = koopPage.getInputField(driver).getText();
        Assert.assertEquals(inputResult,EMPTY);

    }



    /*
    * When pressing on "zoek" with an empty field, results page is loaded
    *
    */

    @Test (groups = "links")
    public void pressSearchWhenFieldIsEmpty(){
        compareLinks(koopPage.getSearchButton(driver),resultsPage.getURL_WHEN_EMPTY());

    }







    /*SEARCHING TESTS*/

    /**
     * This test makes sure that it's possible to search without any data at all
     */
    @Test
    public void searchBuyingPropertiesNoData(){
        koopPage.getSearchButton(driver).click();
    }


    /**
     * This test makes sure that it is possible to search without filters
     */
    public void searchBuyingPropertiesNoFilters(){
        koopPage.getInputField(driver).sendKeys(city);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        koopPage.getSearchButton(driver).click();
    }

    /**
     * These test make sure that it's possible to search using one filter only
     */

    @Test
    public void searchBuyingPropertiesMinRangeOnly(){

    }

    @Test
    public void searchBuyingPropertiesMaxRangeOnly(){


    }


    /**
     * This test makes sure that when no search was done, "Laatste zoekopdracht" is not visible
     */
    @Test
    public void lastSearchFieldDefaultValue(){

        boolean expected = false;
        boolean result=true;

        driver.get(koopPage.getURL());

        if (driver.findElements(lastSearchQuery).size()<1){ //if 0, it means that the value doesn't appear
            result=false;
        }
        Assert.assertEquals(expected,result);

    }

    /**
     * This test checks that the last search query appears, after performing 1 search.
     */
    @Test
    public void lastSearchFieldUpdated(){
        String van = "75.000";
        koopPage.getInputField(driver).sendKeys(city);
        radiusValues.selectByValue(EURO_SIGN+" "+van);
        koopPage.getSearchButton(driver).click();

        driver.get(koopPage.getURL());
        driver.findElement(lastSearchQuery);

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


    private boolean isElementPresent(WebElement element){
        try{
            element.click();
            return true;

        }catch ( ElementNotVisibleException e){

        }
        return false;
    }

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





    /*
     *This method recieves a list of all values of a filter, then selects the first one (to use the "Anders"
     * Then, inserts the value recieved in "keys" into the field
     * Because it receives the elements, this method can be used for HuurPage as well.
     */

    private void enterCharsIntoFilter(Select values, WebElement fieldElement, String keys){
        values.selectByIndex(0);//Select the "Anders" Field
        fieldElement.sendKeys(keys);

    }

    /**
     * This method is reused, and compares to ints, depending on the original's test expectation
     * @param expectedCounter:
     * @param filterCounterNumber: This text will be parsed into int and compared with the expectedCounter.
     */
    private void compareFilterCounterOnResutlsPage(int expectedCounter,String filterCounterNumber){
        int actualCounter = Integer.parseInt(filterCounterNumber);
        Assert.assertEquals(expectedCounter,actualCounter); //if num of filters equals zero, it means that the invalid chars were ignored

    }







    public void getResults(){
        List<WebElement> resultsOnPage=driver.findElements(resultsList);
        System.out.println("results size: "+resultsOnPage.size());


    }







    public void printList(Select s){
        List<WebElement> list = s.getOptions();

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
        }
        System.out.println("size: "+list.size());
    }





}




