package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckFormComponent {
    public void checkFormMethod(String locator, String fieldName, String value) {
        $(locator).$(byText(fieldName)).parent().shouldHave(text(value));
    }
}
