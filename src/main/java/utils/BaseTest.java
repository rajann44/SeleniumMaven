package utils;

import helper.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.time.Duration;

@Listeners(TestListeners.class)
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
