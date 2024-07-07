package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T0_iframe_practice  extends TestBase {
    /*
        go to https://loopcamp.vercel.app/nested-frames.html
        validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

         */
    @Test
    public void test() {
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String leftText = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]")).getText();
        System.out.println(leftText);
    }


}
