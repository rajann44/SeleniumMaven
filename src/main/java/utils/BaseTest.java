package utils;

import config.GSheetKeys;
import helper.GSheetHelper;
import helper.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListeners.class)
public class BaseTest extends DriverManager{

    @BeforeSuite
    public void setData(){
        GSheetHelper.setTestDataFromSheet(GSheetKeys.sheetURL);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        setupDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupMethod(){
        getDriver().quit();
        this.driver.remove();
    }

}
