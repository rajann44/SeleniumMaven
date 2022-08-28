package testScripts_2;

import org.testng.annotations.Test;
import page.ArticlePage;
import page.BasePage;
import page.HomePage;
import utils.BaseTest;

public class TestSection_3 extends BaseTest {

    HomePage homePage;
    ArticlePage articlePage;
    BasePage basePage;

    @Test(groups = "Smoke")
    public void validateWikipediaSearchWorks() {
        homePage = new HomePage(getDriver());
        articlePage = new ArticlePage(getDriver());
        basePage = new BasePage(getDriver());

        basePage.gotToURL("https://wikipedia.com");
        homePage.searchInWikiInputBox("Google");
        articlePage.verifyArticleTitle("Google");
    }


}
