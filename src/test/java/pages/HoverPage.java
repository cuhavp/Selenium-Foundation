package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverPage extends BasePage{

    By avatar1 = By.xpath("//div[@class='figure'][1]");
    By caption1 = By.xpath("//div[@class='figure'][1]/div/h5");
    WebDriverWait wait;
    Actions mouse;

    public HoverPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver,10);
        mouse = new Actions(driver);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverToPerson1(){
        mouse
                .moveToElement(driver.findElement(avatar1))
                .perform();
    }

    public String getPerson1Caption(){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(caption1)).getText();
    }
}
