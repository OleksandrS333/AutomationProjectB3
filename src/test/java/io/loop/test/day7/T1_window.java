package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

/*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */
public class T1_window extends TestBase {

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/windows");
        assertEquals( "Result are not matching" , "The Internet", driver.getTitle());

        System.out.println(driver.getWindowHandle()+ ": This is window unique ID");

        WebElement clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));
        clickHere.click();

        System.out.println("driver Title :" + driver.getTitle());

        String originalWindow = driver.getWindowHandle();
        // storing each window ID to the SET
        Set<String> windowHandles  = driver.getWindowHandles();

        for (String each : windowHandles) {
            System.out.println("each window handle :"  + each);
            driver.switchTo().window(each);
        }

        System.out.println("driver Title :" + driver.getTitle());

        driver.switchTo().window(originalWindow);

        System.out.println("driver Title :" + driver.getTitle());
    }

    @Test
    public void selenium_window(){
        driver.get("http://the-internet.herokuapp.com/windows");
        String curentWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().window(curentWindow);
//        driver.switchTo().newWindow(WindowType.TAB);
    }


}
