package testScripts_2;

import config.GSheetKeys;
import helper.GSheetHelper;
import org.testng.annotations.Test;
import page.ArticlePage;
import page.BasePage;
import page.HomePage;
import utils.BaseTest;

public class TestSection_3 extends BaseTest {

    HomePage homePage;
    ArticlePage articlePage;

    @Test(groups = "Smoke", description = "Validate Wiki Search Works")
    public void validateWikipediaSearchWorks() {
        homePage = new HomePage(getDriver());
        articlePage = new ArticlePage(getDriver());

        homePage.gotToURL(GSheetHelper.getTestDataFromSheet(GSheetKeys.wikiURL));
        homePage.searchInWikiInputBox("Google");
        articlePage.verifyArticleTitle("Google");
    }


}
