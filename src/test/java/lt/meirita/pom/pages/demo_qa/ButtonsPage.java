package lt.meirita.pom.pages.demo_qa;

import lt.meirita.pom.pages.Common;
import lt.meirita.pom.pages.Locator;

public class ButtonsPage {
    public static void openChrome(String url) {
        Common.setUpChrome();
        Common.openUrl(url);
    }

    public static void doubleClickOnButton() {
        Common.doubleClickWithActions(Locator.DemoQa.Buttons.buttonDoubleClick);
    }

    public static String readMessageDoubleClick() {
        return Common.getTextFromElement(Locator.DemoQa.Buttons.paragraphDoubleClick);
    }

    public static void rightClickonButton() {
        Common.rightClickWithActions(Locator.DemoQa.Buttons.buttonRightClick);
    }

    public static String readMessageRightClick() {
        return Common.getTextFromElement(Locator.DemoQa.Buttons.paragraphRightClick);
    }
}
