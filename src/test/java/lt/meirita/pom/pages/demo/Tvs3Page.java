package lt.meirita.pom.pages.demo;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class Tvs3Page {

    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void acceptAgreement() {

        Common.clickOnElementWhenAvailableCustomised(By.xpath("//button[@mode='primary']"), 8);

//        By locator = By.xpath("//span[text()='SUTINKU']/..");
//
//        try {
//            Common.waitElementWhenVisible( locator, 6);
//            Common.clickOnElement(locator);
//        } catch (TimeoutException e){
//            System.out.println("Catch TimeoutException");
//        }


    }

    public static void closeDriver() {
        Common.quitDriver();
    }
}
