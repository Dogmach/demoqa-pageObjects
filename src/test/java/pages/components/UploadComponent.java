package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadComponent {
    public void uploadComponent (String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
    }
}
