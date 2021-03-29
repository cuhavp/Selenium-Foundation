package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HyperLinkPage;

public class LinkTest extends BaseTest{

    @DataProvider
    static Object[][] pages(){
        return new Object[][]{
              new Object[]{"200","status_codes/200"}  ,
              new Object[]{"301","status_codes/301"}  ,
              new Object[]{"404","status_codes/404"}  ,
              new Object[]{"500","status_codes/500"}  ,
        };
    }
    @Test(dataProvider = "pages")
    static void navigateToPage(String name,String expected) {
        HyperLinkPage hyperLinkPage = new HyperLinkPage(driver);
        hyperLinkPage.clickOnText(name);
        Assert.assertTrue(driver.getCurrentUrl().contains(expected));
        hyperLinkPage.clickOnText("here");
    }


}
