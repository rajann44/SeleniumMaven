package testScripts_3;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TestSection_2 extends BaseTest {

    @Test(groups = "Smoke")
    public void test1(){
        getDriver().get("https://bing.com");
    }

    @Test(groups = "Regression")
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

    @Test(groups = "Smoke")
    public void test5(){ getDriver().get("https://yandex.com"); }

}
