package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {
    public void subjectComponent(String locator, String value) {
        $(locator).setValue(value).pressEnter();
    }
}
