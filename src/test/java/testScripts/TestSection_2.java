package testScripts;

import org.testng.annotations.Test;
import utils.BaseTest;

public class TestSection_2 extends BaseTest {

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
        getDriver().get("https://yahoo.com");
    }

    @Test
    public void test5(){ getDriver().get("https://youtube.com"); }

}
