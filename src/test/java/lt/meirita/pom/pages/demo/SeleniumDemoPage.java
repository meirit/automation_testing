package lt.meirita.pom.pages.demo;

import lt.meirita.pom.pages.Common;

public class SeleniumDemoPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void closeDriver() {
        Common.quitDriver();
    }

    public static void openSafari(String url) {
        Common.setUpSafari();
        Common.openUrl(url);
    }
}
