package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class ClickComponent {
    public void clickMethod(String locator){
        $(locator).click();
    }
}
