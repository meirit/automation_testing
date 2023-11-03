package lt.meirita.pom.tests.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import lt.meirita.pom.pages.demo.Tvs3Page;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tv3Test {


    @BeforeMethod
    public void SetUP(){

        Tvs3Page.openChrome("https://www.tv3.lt/");
        Tvs3Page.acceptAgreement();
        }


//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

    @Test
    public void tes01(){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
    @AfterMethod
    public void tearDown(){
        Tvs3Page.closeDriver();
    }
}
