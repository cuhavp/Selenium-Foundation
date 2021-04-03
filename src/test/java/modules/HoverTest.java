package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends BaseTest{


    @Test
    static void hoverAvatar1() {
        HoverPage hoverPage = new HoverPage(driver);
        hoverPage.open();
        hoverPage.hoverToPerson1();
        Assert.assertEquals(hoverPage.getPerson1Caption(),"name: user1");
    }

}
