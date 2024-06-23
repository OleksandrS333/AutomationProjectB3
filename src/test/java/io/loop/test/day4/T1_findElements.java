package io.loop.test.day4;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class T1_findElements {

    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.nba.com");

        List<WebElement> nbaLinks = driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks size : " + nbaLinks.size());

        List<WebElement> nbaLinksXpath = driver.findElements(By.xpath("//a"));
        System.out.println("nbaLinksXpath size : " + nbaLinksXpath.size());

        for (WebElement nbaLink : nbaLinks) {
            if(!nbaLink.getText().equals("")){
                System.out.println("nbaLink: " + nbaLink.getText());
                System.out.println(nbaLink.getAttribute("href"));
            }
        }

//        for (int i = 0; i <nbaLinks.size(); i++) {
//            if(!nbaLinks.get(i).getText().equals("")) {
//                System.out.println(nbaLinks.get(i).getText());
//                System.out.println(nbaLinks.get(i).getAttribute("href"));
//            }

//        }



    }

}
