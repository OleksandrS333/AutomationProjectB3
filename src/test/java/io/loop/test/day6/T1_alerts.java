package io.loop.test.day6;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
Information alert practice
1. Open browser
2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Validate “You successfully clicked an alert” text is displayed

Confirmation alert practice
1. Click to “Click for JS Confirm” button
2. Click to OK button from the alert
3. Verify “You clicked: Ok” text is displayed.
4. Click to “Click for JS Confirm” button
5. Click to Cancel button from the alert
6. Validate “You clicked: Cancel” text is displayed.

Prompt alert practice
1. Click to “Click for JS Prompt” button
2. Send "Loop Academy"
3. Click Ok
4. Validate "You entered: Loop Academy" text is displayed
 */
public class T1_alerts extends TestBase {
    @Test
    public void informationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        clickForJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement seccessMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You successfully clicked an alert";
        String actual = seccessMessageForInformationAlert.getText();
        assertEquals(actual, expected, "Alert was not correct");
    }
    @Test
    public void conformationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickJSConfirm.click();

        driver.switchTo().alert().accept(); // will click ok and accept
        WebElement successMessageForConformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConformationAlert.getText();
        assertEquals(actual, expected, "Alert was not correct");

        clickJSConfirm.click();
        driver.switchTo().alert().dismiss(); // will click cancel - will dismiss alert
        expected = "You clicked: Cancel";
        actual = successMessageForConformationAlert.getText();
        assertEquals(actual, expected, "Alert was not correct");

    }

    @Test
    public void promptAlert(){
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();

        String text = "Loopcamp";

//        driver.switchTo().alert().sendKeys(text);
//        driver.switchTo().alert().accept();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();

        WebElement successMessageForPromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForPromptAlert.getText();
        String expected = "You entered: " + text;
        assertEquals(actual, expected , "Alert was not correct");

        clickJSPrompt.click();
        alert.dismiss();
        actual = successMessageForPromptAlert.getText();
        expected = "You entered: " + null;
        assertEquals(actual, expected, "Alert was not correct");
    }



}
