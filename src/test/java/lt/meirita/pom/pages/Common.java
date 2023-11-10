package lt.meirita.pom.pages;

import lt.meirita.pom.utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
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

    public static boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static List<Boolean> getStatusesOfElements(By locator) {
        List<WebElement> elements = getElements(locator);
        List<Boolean> statuses = new ArrayList<>();

        for (WebElement element : elements) {
            statuses.add(element.isSelected());
        }

        return statuses;
    }

    public static String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public static void selectOptionByValue(By locator, String selectValue) {
        getSelect(locator).selectByValue(selectValue);

    }
    private static Select getSelect(By locator) {
        return new Select(getElement(locator));
    }

    public static void selectOptionByIndex(By locator, int index) {
        getSelect(locator).selectByIndex(index);

    }

    private static Actions getActions(){
        return new Actions(Driver.getDriver());

    }

    public static void doubleClickWithActions(By locator) {
        getActions()
//                .moveToElement(getElement(locator))
                .doubleClick(getElement(locator))
                .perform();

    }

    public static void rightClickWithActions(By locator) {
        getActions()
                .moveToElement(getElement(locator))
                .contextClick()
                .perform();



    }

    public static void multipleSelectWithActions(By locator, String[] values) {

        List<WebElement> elements = getSelect(locator).getOptions();
        Actions actions = getActions();
        actions.keyDown(Keys.COMMAND);

        for (WebElement element : elements) {
            String actual = element.getAttribute("value");
            for (String value : values) {
                if(actual.equals(value)) {
                    actions.click(element);
                }

            }

        }
        actions.perform();

    }
    public static void acceptAlert(){
        Driver.getDriver().switchTo().alert().accept();
    }

    public static String getTextFromAlertBox() {
        return Driver.getDriver().switchTo().alert().getText();
    }

    public static void sendKeysToAlert(String message) {
        Driver.getDriver().switchTo().alert().sendKeys(message);
    }
}
