package utils;

import config.GSheetKeys;
import helper.GSheetHelper;
import helper.TestListeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(TestListeners.class)
public class BaseTest extends DriverManager{

    protected Logger consoleLogger = LogManager.getLogger();

    @BeforeSuite(alwaysRun = true)
    public void setData(){
        consoleLogger.warn("BEFORE SUIT: Getting Data from Sheet and setting Keys.....");
        GSheetHelper.setTestDataFromSheet(GSheetKeys.sheetURL);
    }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod(){
        consoleLogger.info("BEFORE METHOD: Setup Driver and Implicit Wait.....");
        setupDriver();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupMethod(){
        consoleLogger.info("AFTER METHOD: Quit Driver and Destroy Driver Thread.....");
        getDriver().quit();
        this.driver.remove();
    }

}
