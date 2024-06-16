package io.loop.test.day4;

import io.loop.test.utilities.DocuporConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.print.Doc;

public class T000_xpath_getText {
    /*
       1. open chrome
       2. go to docuport
       3. click on forgot password
       4. validate url contains: reset password
       5. validate - Enter the email address associated with yor account
       6. enter forgotpasswordg1@gmail.com to email box
       7. validate send button is displayed
       8. validate cancel button is displayed
       9. click send button
       10. validate - We've sent you an email with a link to reset your password. Please check your email
        */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverUtil.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");

        //click on forgot password
        WebElement forgetPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgetPassword.click();
        //4. validate url contains: rest password
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(DocuporConstants.RESET_PASSWORD)) {
            System.out.println("actual url is: " + actualURL + " Contains: " + DocuporConstants.RESET_PASSWORD + " -> TEST PASSED" ) ;
        } else {
            System.err.println( "actual url is: " + actualURL + " DOESNT contain: " + DocuporConstants.RESET_PASSWORD + " -> TEST FAILED");
        }
        //5.validate - Enter the email address associated with yor account
        WebElement validateMessage = driver.findElement(By.xpath("//*[contains(text(),\"Enter the email\")]"));
        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuporConstants.RESET_PASSWORD_MESSAGE)) {
            System.out.println("good");
        } else {
            System.out.println("bad");
        }
        //6.enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuporConstants.EMAIL_FOR_RESET_PASSWORD);

        // 7. validate send button is displayed
        WebElement sendButton = driver.findElement(By.xpath("//*[contains(text(),'Send')]"));
        // 8. validate cancel button is displayed
        WebElement cancleButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));


        if(cancleButton.isDisplayed()) {
            System.out.println("Test passed cancel is displayed");
        } else {
            System.out.println("Test failed cancel is not displayed");
        }

        if (sendButton.isDisplayed()) {
            System.out.println("Test passed send is displayed");
        } else {
            System.out.println("Test failed send is not displayed");
        }
        //click send Button
        sendButton.click();

        Thread.sleep(3000);

        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        Thread.sleep(5000);

//        String actualSuccessMessage = successMessage.getText();

        try {
            System.out.println(successMessage.getText());
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not there anymore");
        }


    }
}
