package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
   navigate to amazon
   maximize
   navigate back
   navigate forward
   refresh
    */
public class NavigateToAmazon {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();



        driver.get("https://www.amazon.com/ref=nav_logo");

        driver.manage().window().maximize();

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

    }
}
