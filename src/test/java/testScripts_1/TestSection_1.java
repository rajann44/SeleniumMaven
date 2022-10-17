package testScripts_1;

import org.testng.annotations.Test;
import page.ArticlePage;
import utils.BaseTest;

public class TestSection_1 extends BaseTest {

    @Test(groups = "Smoke")
    public void test1(){
        ArticlePage articlePage = new ArticlePage(getDriver());
        articlePage.gotToURL("https://bing.com");
    }

    @Test(groups = "Regression")
    public void test2(){
        getDriver().get("https://duckduckgo.com");
    }

    @Test(groups = "Smoke")
    public void test3(){
        getDriver().get("https://google.com");
    }

    @Test(groups = "Regression")
    public void test4(){
        getDriver().get("https://yandex.com");
    }

    @Test(groups = "Smoke")
    public void test5(){ getDriver().get("https://aol.com"); }

}
