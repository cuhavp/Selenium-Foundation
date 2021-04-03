package modules;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{

    @Test
    static void checkInnerText(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));

        driver.switchTo().frame("frame-left");// you are in left frame
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("LEFT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame(); // you are in top frame

        driver.switchTo().frame("frame-middle"); // you are in middle frame
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("MIDDLE"));

        driver.switchTo().parentFrame(); // you are in top frame

        driver.switchTo().frame("frame-right"); // you are in right frame
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("RIGHT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );
        driver.switchTo().parentFrame(); // you are in top frame

        driver.switchTo().parentFrame(); // you are in origin session

        driver.switchTo().frame("frame-bottom");// you are in bottom frame
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("BOTTOM")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

    }


}
