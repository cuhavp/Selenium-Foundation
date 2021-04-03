package modules;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest {
    protected static WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass
    static void setup(String browser) {

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else {
            throw  new IllegalArgumentException("The browser "+browser+" dose not support yet!!");
        }

    }

    @AfterClass
    static void tearDown() {
        driver.quit();
    }

    @DataProvider
    static Object[][] credentials(){
        return new Object[][]{
                new Object[]{"tomsmith","SuperSecretPassword!","/secure"},
                new Object[]{"tomsmith","SuperSecretPassword@","/login"},
        };
    }

    @Test(dataProvider ="credentials" )
    public static void check(String username,String password,String expectedUrl) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username,password);

        //Step 6:And the home page is appear
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));
    }

}
