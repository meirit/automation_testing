package lt.meirita.pom.pages;

import lt.meirita.pom.utils.Driver;

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
}
