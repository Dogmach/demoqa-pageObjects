package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {
    public void stateAndCityComponent(String locator, String text) {
        $(locator).scrollTo().click();
        $(byText(text)).click();
    }
}
