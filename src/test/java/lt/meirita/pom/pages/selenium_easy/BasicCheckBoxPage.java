package lt.meirita.pom.pages.selenium_easy;

import lt.meirita.pom.pages.Common;
import org.openqa.selenium.By;

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
}
