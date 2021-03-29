package tests;

import org.junit.jupiter.api.Test;
import steps.WebSteps;

public class AnnotatedStepTest extends BaseTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "Listeners NamedBy";
    private WebSteps steps = new WebSteps();

    @Test
    void searchIssueNameWithSteps() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.clickOnIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
