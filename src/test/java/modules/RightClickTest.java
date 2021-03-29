package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

public class RightClickTest extends BaseTest {

    @Test
    static void tc01(){
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.open();
        contextMenuPage.rightClickOnHotpot();

        Assert.assertTrue(contextMenuPage.isAlertPresent());

        Assert.assertEquals(contextMenuPage.getAlertContext(),"You selected a context menu");
    }


}
