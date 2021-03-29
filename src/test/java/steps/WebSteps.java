package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open GitHub page")
    public void openMainPage() {
        open("");
    }

    @Step("Check for repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Open repository {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Open Issues tab")
    public void clickOnIssueTab() {
        $(withText("Issues")).click();
    }

    @Step("Check Issue name {name} is exist")
    public void shouldSeeIssueWithName(String name) {
        $(withText(name)).should(Condition.exist);
    }
}
