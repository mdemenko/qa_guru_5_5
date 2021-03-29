package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaExampleTest extends BaseTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "Listeners NamedBy";

    @Test
    public void lambdaSearchIssueName() {
        step("Open GitHub", () -> open(""));
        step("Search for repository", (step) -> {
            step.parameter("repository",REPOSITORY);

            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Open repository", (step) -> {
            step.parameter("repository",REPOSITORY);
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open Issues tab", () -> $(withText("Issues")).click());
        step("Check Issue name is exist", (step) -> {
            step.parameter("issue name",ISSUE_NAME);
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
    }
}
