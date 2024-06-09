package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLocatorsPractice {

    public static void main(String[] args) {
        // 1
        // create driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // navigate to loopcamp practice page
        https://loopcamp.vercel.app
        driver.get("https://loopcamp.vercel.app/registration_form.html");


        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Loop");

//        WebElement withClassName = driver.findElement(By.className("form-control"));
//        withClassName.sendKeys("Loop");

//        WebElement lastnamwWithClass = driver.findElement(By.className("form-control"));
//        lastnamwWithClass.sendKeys("Academy");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Academy");

        WebElement female = driver.findElement(By.name("gender"));
        female.click();
    }
}
