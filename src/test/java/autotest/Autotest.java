package autotest;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Pages;

import static io.qameta.allure.Allure.step;



public class Autotest {
    Pages pages = new Pages();
    @Test
    @DisplayName("Test yandex authorization")
    public void positiveTest() {

        step("Открыть сайт yandex.ru", () -> {
            pages.openPage();
        });
        step("Перейти на страницу авторизации", () -> {
            pages.clickPageAutorization();
        });
        step("Открыть сайт yandex.ru", () -> {
            pages.loginAndPasswordInput();
        });
        step("Проверка авторизированного пользователя", () -> {
            pages.checkResult();
        });

    }
}