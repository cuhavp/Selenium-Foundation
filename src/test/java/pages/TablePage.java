package pages;

import modules.TableTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import table.Person;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TablePage extends BasePage {
    public List<Person> persons;
    By row = By.xpath("//table[@id='table1']/tbody/tr");

    public TablePage(WebDriver driver) {
        super(driver);
        List<WebElement> rows = driver.findElements(row);

        persons = rows
                .stream()
                .map(TablePage::toPerson)
                .collect(Collectors.toList());
    }

    static Person toPerson(WebElement row) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        String firstName = cells.get(1).getText();
        String lastName = cells.get(0).getText();
        String email = cells.get(2).getText();
        String due = cells.get(3).getText().replace("$", "");// $ 50.00 -> 50.00 -> string -> float
        String website = cells.get(4).getText();
        return new Person(firstName, lastName, email, Float.parseFloat(due), website);
    }

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    public float getMinDue(){
        return persons
                .stream()
                .min(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new)
                .getDue();
    }

    public float getMaxDue(){
        return persons
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new)
                .getDue();
    }
}
