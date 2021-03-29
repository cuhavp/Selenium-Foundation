package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TablePage;
import table.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TableTest extends BaseTest {


    @Test
    void minimumDuePerson() {
        TablePage tablePage = new TablePage(driver);

        List<String> minDuePersons = tablePage.persons
                .stream()
                .filter(person -> person.getDue() == tablePage.getMinDue())
                .map(Person::getFullName)
                .collect(Collectors.toList());


        List<String> expectedPersons = Arrays.asList("John Smith", "Tim Conway");

        Assert.assertEquals(expectedPersons, minDuePersons);
    }

    @Test
    void maximumDuePerson() {
        TablePage tablePage = new TablePage(driver);
        Person maxDuePerson = tablePage.persons
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);

        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    }


}
