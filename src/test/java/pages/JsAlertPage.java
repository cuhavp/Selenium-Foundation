package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JsAlertPage extends BasePage{
    WebDriverWait wait;
    By resultLbl = By.id("result");

    public JsAlertPage(WebDriver driver) {
        super(driver);
         wait = new WebDriverWait(driver,10);

    }

    public void clickOnButton(String name){
        String locator = "//button[.='%s']";
        driver.findElement(By.xpath(String.format(locator,name))).click();
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public boolean isAlertPresent(){
        return (wait.until(ExpectedConditions.alertIsPresent())!=null);
    }

    public void accept(){
        driver.switchTo().alert().accept();

    }

    public void dismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void inputPrompt(String with_text){
        driver.switchTo().alert().sendKeys(with_text);
        driver.switchTo().alert().accept();
    }

    public String getResult(){
        return driver.findElement(resultLbl).getText();
    }
}
