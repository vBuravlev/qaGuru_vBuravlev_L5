import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchDocSoftAssertionTests {

    public int keyJunitNumber;

    @Test
    void successTest() {
        open("https://github.com/selenide/selenide");
        $("[itemprop=name]").shouldHave(text("selenide"));
        $("ul.UnderlineNav-body").$(byText("Wiki")).click(); // проверка ссылки Wiki на странице доки Selenide
        $("div.markdown-body ul li a.internal.present[href*='SoftAssertions']").shouldHave(text("Soft assertions")).click(); //наличие ссылки SoftAssertion на страницу
        $("h3 a#user-content-example").parent().shouldHave(text("Example:"));  // наличие фразы "Example" на странице SoftAssertion

        ElementsCollection lines = $$("div.markdown-body ol"); //Поиск номера примера для JUnit5
        for (int i = 0; i < lines.size(); i++) {
            String expectedValue = lines.get(i).$("li").text();
            String actualValue = "Using JUnit5 extend test class:";
            if (expectedValue.equals(actualValue)) {
                keyJunitNumber = i;
            }
        }
        // проверка блока с кодом на наличие специфических фраз
        $$("div.markdown-body ol").get(keyJunitNumber).sibling(0).shouldHave(text("SoftAssertsExtension"), text("@Test")); //проверка на специфичекские слова для JUnit 5



    }
}
