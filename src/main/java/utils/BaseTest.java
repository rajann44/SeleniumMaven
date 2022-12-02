package utils;

import config.GSheetKeys;
import helper.HttpHandler;
import helper.TestListeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListeners.class)
public class BaseTest extends DriverManager{

    protected Logger consoleLogger = LogManager.getLogger();

    @BeforeTest(alwaysRun = true)
    public void setData(){
        consoleLogger.info("********* Automation Execution Started **********");
        consoleLogger.info("BEFORE SUIT: Getting Data from Sheet and setting Keys.....");
        HttpHandler.setTestDataFromSheet(GSheetKeys.sheetURL);
    }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod(){
        consoleLogger.info("BEFORE METHOD: Setup Driver");
        setupDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanupMethod(){
        consoleLogger.info("AFTER SUITE: Quit Driver and Destroy Driver Thread.....");
        if(getDriver()!=null){getDriver().quit();}
        this.driver.remove();
    }

    @AfterTest(alwaysRun = true)
    public void cleanup(){
        consoleLogger.info("********* Automation Execution Completed **********");
    }

}
