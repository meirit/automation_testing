package lt.meirita.pom.tests.demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import lt.meirita.pom.pages.demo.SeleniumDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SeleniumDemoTest {

    @Test
    public void testWebDriverDemo(){

        SeleniumDemoPage.openChrome("https://www.autobusubilietai.lt/");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testWebDriverDemoWithSafari(){

        SeleniumDemoPage.openSafari("https://www.autobusubilietai.lt/");


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void tearDown(){
        SeleniumDemoPage.closeDriver();
    }
}
