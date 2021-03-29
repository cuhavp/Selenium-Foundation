package modules;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BmiPage;

public class BmiTest extends BaseTest {

    @Test
    static void tc01() {
        BmiPage bmiPage = new BmiPage(driver);
        bmiPage.open();
        bmiPage.openMetricTab();
        bmiPage.fillForm("25", "male", "180", "65");
        Assert.assertEquals(bmiPage.getResult(), "BMI = 20.1 kg/m2   (Normal)");
    }

}
