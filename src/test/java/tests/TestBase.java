package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;
import static properties.SystemProperties.*;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        step("Настраиваем тестируемую страницу", () -> {

            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserSize = browserSize;
            Configuration.remote = "https://" + remoteUser + ":" + remotePassword + "@" + remoteBrowser;
            Configuration.browser = browser;
            Configuration.browserVersion = browserVersion;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        });
    }

    @AfterEach
    void addAttachments() {
        step("Прикрепляем атачи результата теста", () -> {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();
            closeWebDriver();
        });
    }
}