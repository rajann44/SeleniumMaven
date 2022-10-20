package testScripts_1;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import utils.BaseTest;

public class TestSection_2 extends BaseTest {

    @Test(groups = "Regression", description = "Navigate to Bing")
    public void test1(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://bing.com");
    }

    @Test(groups = "Regression", description = "Navigate to DDG")
    public void test2(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://duckduckgo.com");
        Assert.assertTrue(false);
    }

    @Test(groups = "Regression", description = "Navigate to Google")
    public void test3(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://google.com");
    }

    @Test(groups = "Smoke", description = "Navigate to Yahoo")
    public void test4(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://yahoo.com");
    }

    @Test(groups = "Regression", description = "Navigate to Yandex")
    public void test5(){
        HomePage homePage = new HomePage(getDriver());
        homePage.gotToURL("https://yandex.com");
    }

}
