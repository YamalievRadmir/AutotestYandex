package pages;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        //$(".usermenu-portal_js_inited").click(); //клик иконки
        $(".headline__personal-item_mail").click(); //клик почты
        //$(".ns-view-main-action-buttons").shouldBe(Condition.visible);

        //$(".Subname").shouldHave(Condition.text("Test.Testovich1test"));
        //$("[data-bem='{\"usermenu-portal\":{}}']").click();


        //$(".headline__personal-item_mail").click();
        //(".user-account_has-accent-letter_yes").shouldHave(Condition.text("Test.Testovich1test"));

        //$x("//div[@class='Root']//span[contains(@class, 'UserId-FirstLine')]").should(visible, Duration.ofSeconds(10));;
        //$x("//div[contains(@class,'Header-Content')]//span[contains(.,'Тест Тестович')]").shouldBe(Condition.visible);
        //*[contains(@class,'cell-middle-content')]//span[contains(.,'Тест Тестович')].shouldBe(Condition.visible);
        //$(By.xpath("//a[contains(text(),'Test.Testovich1test')]")).shouldHave(Condition.text("Test.Testovich1test"));
        return this;
    }
}
