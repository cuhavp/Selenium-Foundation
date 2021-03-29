package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.How;

public class Browsers {
    private static WebDriver driver;
    
    //todo 1: open browsers
    /**
     * name = open
     * param: browser name in {chrome,firefox,ie, safari ..}
     * return: WebDriver
     */
    
    public static void open(String name){
        switch (name){
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

                driver= new ChromeDriver();
            }
            default:
                throw new IllegalArgumentException("The browser" + name+" dose not support yet!");
        }
    }
    
    public static void visit(String url){
        driver.get(url);
    }


    public static WebElement find(How how, String locator){
       return driver.findElement(how.buildBy(locator));
    }
}
