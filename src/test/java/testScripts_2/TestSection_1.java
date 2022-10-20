package testScripts_2;

import org.testng.annotations.Test;
import page.ArticlePage;
import page.HomePage;
import utils.BaseTest;

public class TestSection_1 extends BaseTest {

    @Test(groups = "Smoke", description = "Navigate to Bing")
    public void test1(){
        ArticlePage articlePage = new ArticlePage(getDriver());
        articlePage.gotToURL("https://bing.com");
    }

    @Test(groups = "Regression", description = "Navigate to DDG")
    public void test2(){
        ArticlePage articlePage = new ArticlePage(getDriver());
        articlePage.gotToURL("https://duckduckgo.com");
    }

    @Test(groups = "Smoke", description = "Navigate to Google")
    public void test3(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://google.com");
    }

    @Test(groups = "Regression", description = "Navigate to Yandex")
    public void test4(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://yandex.com");
    }

    @Test(groups = "Smoke", description = "Navigate to AOL")
    public void test5(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://aol.com");
    }

}
