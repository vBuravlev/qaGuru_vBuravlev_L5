import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchDocSoftAssertionTests {

    public int keyJunitNumber;

    @Test
    void successTest() {
        open("https://github.com/selenide/selenide");
        $("ul span[data-content='Wiki']").should(visible).click(); // проверка ссылки Wiki на странице доки Selenide
        $x("//a[@class='internal present' and @href='/selenide/selenide/wiki/SoftAssertions']")
                .shouldHave(text("Soft Assertions")).click(); //наличие ссылки SoftAssertion на страницу
        $x("//h3[text()='Example:']").shouldBe(visible);  // наличие фразы "Example" на странице SoftAssertion

        ElementsCollection lines = $$("div.markdown-body ol"); //Поиск номера примера для JUnit5
        for (int i = 1; i < lines.size(); i++) {
            String expectedValue = lines.get(i).$("li").text();
            String actualValue = "Using JUnit5 extend test class:";
            if (expectedValue.equals(actualValue)) {
                keyJunitNumber = i;
            }
        }
        // проверка блока с кодом на наличие специфических фраз
        $$("ol[start='" + keyJunitNumber + "'] + div pre span").findBy(text("SoftAssertsExtension"))
                .shouldBe(visible);
        $$("ol[start='" + keyJunitNumber + "'] + div pre span").findBy(text("@Test"))
                .shouldBe(visible);


    }
}
