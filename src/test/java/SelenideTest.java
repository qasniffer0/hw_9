import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void issueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $("[name=q]").sendKeys("qasniffer0/hw_8");
        $("[name=q]").submit();
        $(linkText("qasniffer0/hw_8")).click();
        $("#issues-tab").click();
        $(withText("#01")).should(Condition.exist);
    }
}
