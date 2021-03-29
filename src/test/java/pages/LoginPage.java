package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By usernameTxt = By.id("username");
    By passwordTxt = By.id("password");
    By loginBtn = By.xpath("//button[contains(.,'Login')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        driver.findElement(usernameTxt).sendKeys(username);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}
