package utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends DriverManager{

    @BeforeMethod
    public void beforeMethod(){
        setupDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void cleanupMethod(){
        getDriver().quit();
        this.driver.remove();
    }

}
