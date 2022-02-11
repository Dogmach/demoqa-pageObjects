package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class LineFillComponent {
    public void lineFill(String locator, String text) {
        $(locator).setValue(text);
    }
}
