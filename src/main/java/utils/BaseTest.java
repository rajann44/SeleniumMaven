package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManager{

    @BeforeMethod
    public void beforeMethod(){
        setupDriver();
    }

    @AfterMethod
    public void cleanupMethod(){
        getDriver().quit();
        this.driver.remove();
    }

}
