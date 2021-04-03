package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ToDoPage;

public class TodoTest extends BaseTest {

    @Test
    void createNew() {
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.open();

        int itemLeftBefore = toDoPage.getItemsLeft();
        toDoPage.addNew("task 1");

        int itemLeftAfter = toDoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore, 1);
    }

    @Test
    void removeTodo()  {
        ToDoPage toDoPage = new ToDoPage(driver);
        toDoPage.open();

        toDoPage.addNew("task 1");
        int itemLeftBefore = toDoPage.getItemsLeft();

        toDoPage.removeTodo("task 1");
        int itemLeftAfter = toDoPage.getItemsLeft();
        Assert.assertEquals(itemLeftAfter - itemLeftBefore, -1);

    }
}
