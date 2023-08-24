package config;

import com.codeborne.selenide.Configuration;
import helpers.AllureAttachments;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    public static void setUp() {
        WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.browser = webDriverConfig.getBrowser();
        Configuration.browserVersion = webDriverConfig.getBrowserVersion();
        Configuration.browserSize = webDriverConfig.getBrowserSize();
        if (!webDriverConfig.getRemoteWebDriver().isEmpty()) {
            Configuration.remote = webDriverConfig.getRemoteWebDriver();
        }
        String baseUrlOfPage = System.getProperty("base.url");
        if (Objects.isNull(baseUrlOfPage)) {
            baseUrlOfPage= "https://www.yandex.ru/";
        }
        open(baseUrlOfPage);
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Скриншот");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();
        closeWebDriver();
    }
}