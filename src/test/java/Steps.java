import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    private static final String REPO = "qasniffer0/hw_8";
    private static final int NUMBER_ISSUE = 1;

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com/");
    }

    @Step("Ищем репозиторий {repo}")
    public void searchRepo(String repo) {
        $("[name=q]").sendKeys(repo);
        $("[name=q]").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void repositoryClickLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем tab Issue")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {number}")
    public void shouldIssueNumberVisible(int number) {
        $(withText("#" + number)).should(Condition.exist);
    }

    @Test
    public void annotationsStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Steps steps = new Steps();
        steps.openMainPage();
        steps.searchRepo(REPO);
        steps.repositoryClickLink(REPO);
        steps.openIssue();
        steps.shouldIssueNumberVisible(NUMBER_ISSUE);
    }
}
