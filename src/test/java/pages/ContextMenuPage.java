package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends BasePage{
    Actions mouse;
    WebDriverWait wait;
    By hotpotRec = By.id("hot-spot");
    public ContextMenuPage(WebDriver driver) {
        super(driver);
        mouse = new Actions(driver);
        wait = new WebDriverWait(driver,10);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightClickOnHotpot(){
        WebElement hotPot = driver.findElement(hotpotRec);
        mouse.contextClick(hotPot).perform();
    }

    public boolean isAlertPresent(){
        return (wait.until(ExpectedConditions.alertIsPresent())!=null);
    }

    public String getAlertContext(){
        String jsContext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return jsContext;
    }
}
