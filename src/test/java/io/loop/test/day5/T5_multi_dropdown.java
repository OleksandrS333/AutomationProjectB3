package io.loop.test.day5;

import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T5_multi_dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void multiSelect() throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='cars']")));
        // isMultiple - allows us to test if dropdown is multiple
        Assert.assertTrue(dropdown.isMultiple(), "Dropdown is not multiple");

//        dropdown.selectByIndex(0);
//        Thread.sleep(3000);
//        dropdown.selectByValue("saab");
//        Thread.sleep(3000);
//        dropdown.selectByVisibleText("Opel");
//        Thread.sleep(3000);
//        dropdown.selectByIndex(3);

        List <WebElement> options;
        options = dropdown.getOptions(); //storing all dropdown into a list

//        for (WebElement option : options){
//            option.click();
//            System.out.println(option.getText());
//        }
//
        options.forEach(option -> {option.click();
        System.out.println(option.getText());});

    }


//    @AfterMethod
//    public void tearDownMethod() {
//        driver.close();
//    }
}