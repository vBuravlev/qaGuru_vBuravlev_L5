import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirsHomework {


    //селектор вида $("div h3") будет искать любого первого потомка в DOM дереве

    //работающий тест
    @Test
    void successTest() {
        open("https://github.com/qa-guru/demoqa-tests-11/branches");
        $("div a.btn.btn-sm.d-none.d-lg-inline-block.test-compare-link").click();
        sleep(3000);
    }

    //селектор вида $("div").$("h3") будет искать непосредственного потомка

    //падающий тест
    @Test
    void successTest2() {
        open("https://github.com/qa-guru/demoqa-tests-11/branches");
        $("div").$("a.btn.btn-sm.d-none.d-lg-inline-block.test-compare-link").click();
        sleep(3000);
    }

}
