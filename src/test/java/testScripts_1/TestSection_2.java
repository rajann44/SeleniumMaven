package testScripts_1;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class TestSection_2 extends BaseTest {

    @Test(groups = "Regression")
    public void test1(){
        getDriver().get("https://bing.com");
    }

    @Test(groups = "Smoke")
    public void test2(){
        getDriver().get("https://duckduckgo.com");
        Assert.assertTrue(false);
    }

    @Test(groups = "Regression")
    public void test3(){
        getDriver().get("https://google.com");
    }

    @Test(groups = "Smoke")
    public void test4(){
        getDriver().get("https://yahoo.com");
    }

    @Test(groups = "Regression")
    public void test5(){ getDriver().get("https://yandex.com"); }

}
