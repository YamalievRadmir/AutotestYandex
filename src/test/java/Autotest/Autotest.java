package Autotest;


import config.WebDriverProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;



public class Autotest {

    private WebDriver driver;
    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }
    @Test
    @DisplayName("Test yandex authorization")
    public void positiveTest() {

        step("Открыть сайт yandex.ru", () -> {
            open("https://ya.ru");
                });
        step("Перейти на страницу авторизации", () -> {
            $(".headline__personal-enter").click();
                });
        step("Открыть сайт yandex.ru", () -> {
            $("[data-t='field:input-login']").click();
            $("[data-t='field:input-login']").setValue("Test.Testovich1test");
            $("[data-t='button:action:passp:sign-in']").click();
            $("[data-t='field:passwd']").click();
            $("[data-t='field:input-passwd']").setValue("Test.Testovich1test1");
            $("[data-t='button:action:passp:sign-in']").click();
        });
        step("Проверка авторизированного пользователя", () -> {
            $("[data-bem='{\"usermenu-portal\":{}}']").click();
                });
        //$("[class=\"UserId-FirstLine\"]").shouldHave(Condition.text("Тест Тестович"));
        //$("[data-bem='{\"usermenu-portal\":{}}']").click();


        //$(".headline__personal-item_mail").click();
        //(".user-account_has-accent-letter_yes").shouldHave(Condition.text("Test.Testovich1test"));

        //$x("//div[@class='Root']//span[contains(@class, 'UserId-FirstLine')]").should(visible, Duration.ofSeconds(10));;
        //$x("//div[contains(@class,'Header-Content')]//span[contains(.,'Тест Тестович')]").shouldBe(Condition.visible);
        //*[contains(@class,'cell-middle-content')]//span[contains(.,'Тест Тестович')].shouldBe(Condition.visible);
        //$(By.xpath("//a[contains(text(),'Test.Testovich1test')]")).shouldHave(Condition.text("Test.Testovich1test"));
    }
}