package testScripts_2;

import org.testng.annotations.Test;
import page.ArticlePage;
import page.CommonAction;
import page.HomePage;
import utils.BaseTest;

public class TestSection_3 extends BaseTest {

    HomePage homePage;
    ArticlePage articlePage;
    CommonAction commonAction;

    @Test
    public void validateWikipediaSearchWorks() {
        homePage = new HomePage(getDriver());
        articlePage = new ArticlePage(getDriver());
        commonAction = new CommonAction(getDriver());

        commonAction.gotToURL("https://wikipedia.com");
        homePage.searchInWikiInputBox("Google");
        articlePage.verifyArticleTitle("Google");
    }


}
