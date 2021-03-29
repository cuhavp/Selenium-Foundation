package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class CheckboxPage extends BasePage{
    HashMap<String, By> checkboxes;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkboxes.put("checkbox1", By.xpath("//form[@id='checkboxes']/input[1]"));
        checkboxes.put("checkbox2", By.xpath("//form[@id='checkboxes']/input[2]"));
    }

    public void check(String name) {
        WebElement checkbox = driver.findElement(checkboxes.get(name));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void uncheck(String name) {
        WebElement checkbox = driver.findElement(checkboxes.get(name));
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public boolean isSelected(String name) {
        return driver.findElement(checkboxes.get(name)).isSelected();
    }

}
