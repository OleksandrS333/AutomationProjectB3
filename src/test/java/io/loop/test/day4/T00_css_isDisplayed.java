package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 http://the-internet.herokuapp.com/forgot-password
  */
public class T00_css_isDisplayed {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class=\"example\"]>h2"));
        String forgotPasswordText = forgotPasswordHeading.getText();
        System.out.println(forgotPasswordText);

        System.out.println(forgotPasswordHeading.isDisplayed());

        if (forgotPasswordHeading.isDisplayed()) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test fail");
        }


    }
}
