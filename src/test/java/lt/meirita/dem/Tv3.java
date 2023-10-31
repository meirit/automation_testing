package lt.meirita.dem;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tv3 {

    private WebDriver driver;

    @BeforeMethod
    public void SetUP(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--force-device-scale-factor=0.75");


        driver = new ChromeDriver(options);

//        driver.get("chrome://settings/");
//        ((JavascriptExecutor) driver).executeScript("chrome.settingsPrivate.setDefaultZoom(0.5)");

        driver.get("https://www.tv3.lt/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));





//        WebElement buttonSutinku = driver.findElement(By.xpath("//button[@mode='primary']"));
        int seconds = 8;

        for (int i=0; (i<= seconds*2); i++){
        try {
            WebElement buttonSutinku = driver.findElement(By.xpath("//span[text()='SUTINKU']/.."));
            buttonSutinku.click();

//        int seconds = 8;

//        for (int i=0; (i<= seconds*2); i++){
//            if(buttonSutinku.isDisplayed()){
//                buttonSutinku.click();
//                break;
//            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

//        }
        }catch (NoSuchElementException e){

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    e.printStackTrace();
                }

            }
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

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
//        driver.quit();
    }
}
