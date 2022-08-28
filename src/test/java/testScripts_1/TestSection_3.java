package testScripts_1;

import org.testng.annotations.Test;
import page.ArticlePage;
import page.BasePage;
import page.HomePage;
import utils.BaseTest;

public class TestSection_3 extends BaseTest {

    HomePage homePage;
    ArticlePage articlePage;

    @Test(groups = "Regression")
    public void validateWikipediaSearchWorks() {
        homePage = new HomePage(getDriver());
        articlePage = new ArticlePage(getDriver());

        homePage.gotToURL("https://wikipedia.com");
        homePage.searchInWikiInputBox("Google");
        articlePage.verifyArticleTitle("Google");
    }


}
