package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class Pages {

    public Pages openPage() {
        open("https://ya.ru");
        return this;
    }
    public Pages clickPageAutorization() {
        $(".headline__personal-enter").click();
        return this;
    }

    public Pages loginAndPasswordInput() {
        $("[data-t='field:input-login']").click();
        $("[data-t='field:input-login']").setValue("Test.Testovich1test");
        $("[data-t='button:action:passp:sign-in']").click();
        $("[data-t='field:passwd']").click();
        $("[data-t='field:input-passwd']").setValue("Test.Testovich1test1");
        $("[data-t='button:action:passp:sign-in']").click();
        return this;
    }

    public Pages checkResult() {
        $(".usermenu-portal_js_inited").click(); //клик иконки
        Selenide.switchTo().frame($x("//iframe"));
        String s = String.valueOf($x("//div[@class='Root']//span[contains(@class, 'UserId-FirstLine')]").shouldHave(Condition.text("Тест Тестович")));
        System.out.println(s);
        return this;
    }
}
