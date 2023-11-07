package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import org.openqa.selenium.By;

import java.util.List;

public class BasicCheckBoxPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void checkOnCheckBox() {
        Common.clickOnElement(
                By.xpath(
                        "//input[@id='isAgeSelected']"
                )
        );
    }

    public static String readSingleCheckBoxMessage() {
        return Common.getTextFromElement(By.xpath("//div[@id='txtAge']"));
    }

    public static boolean checkDefaultSelected() {
        return Common.isElementSelected(
                By.xpath("(//form//input[@type='checkbox'])[2]")
        );
    }

    public static boolean checkDefaultEnabled() {
        return Common.isElementEnabled(
                By.xpath("(//form//input[@type='checkbox'])[3]")
        );
    }

    public static void clickOnButtonCheckAll() {
        Common.clickOnElement(By.xpath("//input[@id='check1']"));
    }

    public static boolean checkStatusesOfCheckBoxGroup(boolean expectedStatus) {
        List<Boolean> statuses = Common.getStatusesOfElements(By.xpath("//input[@class='cb1-element']"));

        for (Boolean status : statuses) {
            if(status != expectedStatus) return false;
        }

        return true;

    }

    public static String getButtonAttributeValue(String attributeName) {
        return Common.getElementAttributeValue(
                By.xpath("//input[@id='check1']"),
                attributeName
        );
    }
}
