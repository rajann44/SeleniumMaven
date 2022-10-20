package testScripts_1;

import config.GSheetKeys;
import helper.HttpHandler;
import org.testng.annotations.Test;
import page.ArticlePage;
import page.HomePage;
import utils.BaseTest;

public class TestSection_3 extends BaseTest {

    HomePage homePage;
    ArticlePage articlePage;

    @Test(groups = "Regression", description = "Validate Wiki Search Works")
    public void validateWikipediaSearchWorks() {
        homePage = new HomePage(getDriver());
        articlePage = new ArticlePage(getDriver());

        homePage.gotToURL(HttpHandler.getTestDataFromSheet(GSheetKeys.wikiURL));
        homePage.searchInWikiInputBox("Google");
        articlePage.verifyArticleTitle("Google");
    }


}
