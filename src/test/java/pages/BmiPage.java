package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BmiPage extends BasePage{

    /**
     * suffix for locator variables
     * btn --> button
     * txt --> input text box
     * rad --> radio button
     * chk --> check box
     * link --> linkText
     * lbl --> label
     * ...
     */
     By metricUnitTab = By.xpath("//a[.='Metric Units']");
     By ageTxt = By.id("cage");
     By maleRad = By.id("csex1");
     By femaleRad = By.id("csex2");
     By heightTxt = By.id("cheightmeter");
     By weightTxt = By.id("ckg");
     By calculateBtn = By.xpath("//input[@alt='Calculate']");
     By resultLbl = By.className("bigtext");
     By clearBtn = By.className("clearbtn");


    public BmiPage(WebDriver driver) {
        super(driver);
    }
    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }

    public String getResult() {
        return driver.findElement(resultLbl).getText();
    }

    public void fillForm(String age, String gender, String height, String weight) {

        driver.findElement(clearBtn).click();

        driver.findElement(ageTxt).sendKeys(age);

        if (gender.equalsIgnoreCase("male"))
            driver.findElement(maleRad).click();
        else driver.findElement(femaleRad).click();

        driver.findElement(heightTxt).sendKeys(height);

        driver.findElement(weightTxt).sendKeys(weight);

        driver.findElement(calculateBtn).click();
    }

    public void openMetricTab() {
        driver.findElement(metricUnitTab).click();
    }
}
