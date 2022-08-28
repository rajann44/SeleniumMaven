package testScripts_2;

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
    }

    @Test(groups = "Regression")
    public void test3(){
        getDriver().get("https://google.com");
    }

    @Test(groups = "Regression")
    public void test4(){
        getDriver().get("https://yahoo.com");
    }

    @Test(groups = "Regression")
    public void test5(){ getDriver().get("https://yandex.com"); }

}
