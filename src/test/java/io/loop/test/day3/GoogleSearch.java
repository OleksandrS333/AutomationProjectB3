package io.loop.test.day3;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the brower
 */
public class GoogleSearch {
    public static void main(String[] args) {

        // in selenium 3 we had to set up the driver, for that we need webdrivermanager libraries
        // WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();

        // navigate to google
        driver.get("https://www.google.com");

        // maximize
        driver.manage().window().maximize();

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.printf("Actual title: " + actualTitle + ", matches expected title: " + expectedTitle + ". => TEST PASS");
        } else {
            System.out.println("Actual title: " + actualTitle + ", DOES NOT MATCH expected title: " + expectedTitle + ". => TEST FAIL");
        }
        System.out.println();
        String expectedURL = "https://www.google.com";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedURL) ) {
            System.out.println("Actual url: " + actualURL + ", matches expected url: " + expectedURL + ". => TEST PASS");
        } else {
            System.err.println("Actual url: " + actualURL + ", DOES NOT match expected url: " + expectedURL + ". => TEST FAIL");
        }

    }


}
