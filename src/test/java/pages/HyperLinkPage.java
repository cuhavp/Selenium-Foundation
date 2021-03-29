package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyperLinkPage {

    WebDriver driver;

    public HyperLinkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickOnText(String text){
        driver.findElement(By.linkText(text)).click();
    }
}
