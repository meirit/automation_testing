package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SeleniumDemo {

    @Test
    public void testWebDriverDemo(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.autobusubilietai.lt/");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

//    @Test
//    public void testWebDriverDemoWithSafari(){
//
//        WebDriverManager.safaridriver().setup();
//
//        WebDriver driver = new SafariDriver();
//        driver.get("https://www.autobusubilietai.lt/");
//
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.quit();
//
//    }
}
