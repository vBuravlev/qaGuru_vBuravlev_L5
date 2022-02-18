import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ActionsTests {

    //Действие с помощью action() не совершается
    @Test
    void successTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("div#column-a").$("header").shouldHave(text("A"));
        $("div#column-b").$("header").shouldHave(text("B"));
        SelenideElement element = $("div#column-a");
        actions().dragAndDropBy(element, 150, 0).perform();
        $("div#column-a").$("header").shouldHave(text("B"));
        $("div#column-b").$("header").shouldHave(text("A"));
    }
}
