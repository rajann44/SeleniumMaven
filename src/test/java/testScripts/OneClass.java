package testScripts;

import org.testng.annotations.Test;
import utils.DriverManager;

public class OneClass {

    DriverManager driverManager = new DriverManager();

    @Test
    public void test1(){
        driverManager.getDriver().get("https://bing.com");
    }

    @Test
    public void test2(){
        driverManager.getDriver().get("https://duckduckgo.com");
    }

    @Test
    public void test3(){
        driverManager.getDriver().get("https://google.com");
    }

    @Test
    public void test4(){
        driverManager.getDriver().get("https://yahoo.com");
    }

    @Test
    public void test5(){
        driverManager.getDriver().get("https://ask.com");
    }


}
