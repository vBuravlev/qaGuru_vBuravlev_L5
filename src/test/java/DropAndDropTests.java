import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DropAndDropTests {

    @Test
    void successTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("div#column-a").$("header").shouldHave(text("A"));
        $("div#column-b").$("header").shouldHave(text("B"));
        $("div#column-a").dragAndDropTo($("div#column-b"));
        $("div#column-a").$("header").shouldHave(text("B"));
        $("div#column-b").$("header").shouldHave(text("A"));
    }
}
