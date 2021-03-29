package browsers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {
    /**
     * The path to the driver executable must be set by the webdriver.chrome.driver
     * system property;
     * @param args
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(10,10));
        driver.navigate().to("https://google.com.vn");
        driver.get("https://selenium.dev");
        driver.navigate().back();
        driver.manage().window().setSize(new Dimension(50,10));

        driver.quit();
//        driver.navigate().to("https://google.com.vn");
    }


}
