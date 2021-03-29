package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.JsAlertPage;

public class JsAlertTest extends BaseTest {



    @Test
    static void clickForJsAlert() {
        JsAlertPage jsAlertPage = new JsAlertPage(driver);
        jsAlertPage.open();
        jsAlertPage.clickOnButton("Click for JS Alert");

        Assert.assertTrue(jsAlertPage.isAlertPresent());

        jsAlertPage.dismiss();

        Assert.assertEquals(jsAlertPage.getResult(), "You successfully clicked an alert");
    }

    @DataProvider
    static Object[][] confirmActions() {
        return new Object[][]{
                new Object[]{"Cancel"},
                new Object[]{"Ok"}
        };
    }

    @Test(dataProvider = "confirmActions")
    static void clickForJsConfirm(String action) {
        JsAlertPage jsAlertPage = new JsAlertPage(driver);
        jsAlertPage.open();
        jsAlertPage.clickOnButton("Click for JS Confirm");

        //todo: dismiss alert via click OK button
        Assert.assertTrue(jsAlertPage.isAlertPresent());

        if (action.contains("Cancel")) {
            jsAlertPage.dismiss();
        } else {
            jsAlertPage.accept();
        }

        Assert.assertEquals(jsAlertPage.getResult(), String.format("You clicked: %s", action));
    }

    @Test
    static void clickForJsPrompt() {
        JsAlertPage jsAlertPage = new JsAlertPage(driver);
        jsAlertPage.open();
        jsAlertPage.clickOnButton("Click for JS Prompt");

        //todo: dismiss alert via click OK button
        Assert.assertTrue(jsAlertPage.isAlertPresent());
        jsAlertPage.inputPrompt("Hello");
        Assert.assertEquals(jsAlertPage.getResult(), "You entered: Hello");
    }


}
