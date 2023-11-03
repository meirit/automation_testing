package lt.meirita.pom.pages;

import lt.meirita.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Common {

    public static void setUpChrome() {
        Driver.setChromeDriver();
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void quitDriver() {
        Driver.quitDriver();
    }

    public static void setUpSafari() {
        Driver.setSafariDriver();
    }

    private static  WebElement getElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    private static  List<WebElement> getElements(By locator){
        return Driver.getDriver().findElements(locator);
    }

    public static  void sendKeysToElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public static String getTextFromElement(By locator){
        return getElement(locator).getText();
    }

    public static  void clickOnElement(By locator){
        getElement(locator).click();

    }



    public static void clickOnElementWhenAvailableCustomised(By locator, int seconds) {

        for (int i = 0; i <= (seconds * 2); i++) {
            try {
//        WebElement buttonSutinku = driver.findElement(By.xpath("//span[text()='SUTINKU']/.."));
                Thread.sleep(500);
                clickOnElement(locator);
                break;
            } catch (NoSuchElementException | InterruptedException e) {

            }
        }

    }

    public static void waitElementWhenVisible(By locator, int seconds) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }
}
