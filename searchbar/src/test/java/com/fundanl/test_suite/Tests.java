package com.fundanl.test_suite;

import com.fundanl.test_suite.PageObjects.HuurPage;
import com.fundanl.test_suite.PageObjects.KoopPage;
import com.fundanl.test_suite.PageObjects.NieuwbouwPage;
import com.fundanl.test_suite.PageObjects.RecreatiePage;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Tests extends Base{
    private Select radiusValues,rangeMinValues,rangeMaxValues;
    private WebDriverWait wait;
    private KoopPage koopPage;
    private HuurPage huurPage;
    private NieuwbouwPage nieuwbouwPage;
    private RecreatiePage recreatiePage;

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

        driver.get(koopPage.getURL());

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //time to pass the i'm not a robot


        System.out.println("Creating list for radius");
        radiusValues=new Select(koopPage.getRadius());
        rangeMinValues=new Select(koopPage.getRangeMin());
        rangeMaxValues=new Select(koopPage.getRangeMax());
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
        koopPage.getKoopButton().isEnabled();
    }

    @Test(groups = "visibility")
    public void huurTabVisibility(){
        koopPage.getHuurButton().isEnabled();
    }


    @Test(groups = "visibility")
    public void nieuwbouwTabVisibility(){
        koopPage.getNiewbiuwButton().isEnabled();
    }

    @Test(groups = "visibility")
    public void recreatieTabVisibility(){
        koopPage.getRecreatieButton().isEnabled();
    }

    @Test(groups = "visibility")
    public void europaTabVisibility(){
        koopPage.getEuropeButton().isEnabled();
    }

    @Test(groups = "visibility")
    public void inputFieldVisibility(){
        koopPage.getInputField().isEnabled();
    }

    @Test(groups = "visibility")
    public void radiusFilterVisibility(){
        koopPage.getRadiusFilter().isEnabled();
    }

    @Test(groups = "visibility")
    public void vanFilterVisibility(){
        koopPage.getRangeMin().isEnabled();
    }

    @Test(groups = "visibility")
    public void totFilterVisibility(){
        koopPage.getRangeMax().isEnabled();
    }

    @Test(groups = "visibility")
    public void searchBttonVisibility(){
        koopPage.getSearchButton().isEnabled();
    }


    /**
     * These tests check the the links work properly
     */
    @Test(groups="links")
    public void pressOnHuur(){
        String resultURL;

        //loadHome();
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        koopPage.getHuurButton().click();
        System.out.println("clicked");
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        resultURL=driver.getCurrentUrl();




        System.out.println(resultURL+" "+huurPage.getURL());
       // Assert.assertSame(resultURL,huurPage.getURL());

    }



    /*titles*/


    /*Search field tests*/

    @Test
    public void searchBuyingPropertiesNoFilters(){

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(koopPage.getRadiusID())));

        koopPage.getInputField().sendKeys(city);
        koopPage.getSearchButton().click();
    }

/* Description: This test depends on the previous one, and the search results are checked
 * Expected: All results
 */

    @Test
    public void checkAutoComplete(){
        loadHome();
        koopPage.getInputField().sendKeys(city.substring(3));

    }



    private void loadHome(){
        driver.get(koopPage.getURL());
    }



}
