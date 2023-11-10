package lt.meirita.pom.pages;

import org.openqa.selenium.By;

public class Locator {
    public static class SeleniumEasy {
        public static class BasicCheckBox {
            public static By inputIsAgeSelected = By.xpath("//input[@id='isAgeSelected']");
            public static By divTxtAge = By.xpath("//div[@id='txtAge']");
            public static By CheckBoxDefaultSelected= By.xpath("(//form//input[@type='checkbox'])[2]");
            public static By CheckBoxDefaultEnabled=By.xpath("(//form//input[@type='checkbox'])[3]");
            public static By buttonCheckAll=By.xpath("//input[@id='check1']");
            public static By checkBoxMultiple=By.xpath("//input[@class='cb1-element']");
        }

        public static class BasicFirstForm {

            public static By inputUserMessage = By.xpath("//input[@id='user-message']");
            public static By buttonShowMessage= By.xpath("//button[@onclick='showInput();']");
            public static By readUserMessage=By.xpath("//div[@id='user-message']//span");
            public static By buttonGetTotal=By.xpath("//button[@onclick='return total()']");
            public static By displayValue= By.xpath("//span[@id='displayvalue']");

            public static By setValueById(String attributeId) {
                return By.xpath("//input[@id='%s']".formatted(attributeId));
            }
        }

        public static class BasicSelectDropdown {
            public static By selectDayOfWeek = By.xpath("//select[@id='select-demo']");
            public static By paragraphSelectedDay = By.xpath("//p[@class='selected-value']");
            public static By selectState= By.xpath("//select[@id='multi-select']");
        }

        public static class BasicRadioButton {

            public static By buttonGetValue= By.xpath("//button[@id='buttoncheck']");
            public static By paragraphCheckedValue =By.xpath("//p[@class='radiobutton']");

            public static By setGenderRadioButton(String selectedValue) {
                return By.xpath("//input[@value='%s' and @name='optradio']".formatted(selectedValue));
            }
        }
    }

    public static class DemoQa {
        public static class TextBox {
            public static By inputUserName=By.xpath("//input[@id='userName']");
            public static By inputUserEmail = By.xpath("//input[@id='userEmail']");
            public static By buttonSubmit= By.xpath("//button[@id='submit']");
            public static By paragraphName = By.xpath("//p[@id='name']");
            public static By paragraphEmail = By.xpath("//p[@id='email']");

            public static By setInputById(String attributeId) {
                return By.xpath("//input[@id='%s']".formatted(attributeId));
            }

            public static By setParagraphById(String attributeId) {
                return By.xpath("//p[@id='%s']".formatted(attributeId));
            }
        }

        public static class Buttons {

            public static By buttonDoubleClick= By.xpath("//button[@id='doubleClickBtn']");
            public static By paragraphDoubleClick = By.xpath("//p[@id='doubleClickMessage']");
            public static By buttonRightClick= By.xpath("//button[@id='rightClickBtn']");
            public static By paragraphRightClick = By.xpath("//p[@id='rightClickMessage']");
        }
    }
}
