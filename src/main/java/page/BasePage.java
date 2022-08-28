package page;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;
    static ThreadLocal<ExtentTest> logger;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public static void setLogger(ThreadLocal<ExtentTest> extentTestThreadLocal){
        logger = extentTestThreadLocal;
    }

    public void logInfo(String logInfo){
        logger.get().info(logInfo);
    }

    public void gotToURL(String url){
        driver.get(url);
    }


}
