package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"
     */
public class T3_getAttribute_css {

    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://beta.docuport.app");


        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));
        String docuport = logo.getAttribute("alt");
        System.out.println(docuport);

        if(docuport.equals(DocuportConstants.LOGO_DOCUPORT)) {
            System.out.println("Expected logo: " + docuport + " matches: " + DocuportConstants.LOGO_DOCUPORT + " -> TEST PASSED");
        } else {
            System.err.println("Expected logo: " + docuport + " DOESNT match: " + DocuportConstants.LOGO_DOCUPORT + " -> TEST FAILED");
        }

    }


}
