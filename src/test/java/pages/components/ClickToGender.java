package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ClickToGender {
        public void clickToGenderMethod(String locator,String value){
            $(locator).$(byText(value)).click();
        }
}
