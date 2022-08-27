package testScripts_3;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TestSection_1 extends BaseTest {

    @Test
    public void test1(){
        getDriver().get("https://bing.com");
    }

    @Test
    public void test2(){
        getDriver().get("https://duckduckgo.com");
    }

    @Test
    public void test3(){
        getDriver().get("https://google.com");
    }

    @Test
    public void test4(){
        getDriver().get("https://yandex.com");
    }

    @Test
    public void test5(){ getDriver().get("https://aol.com"); }

}
