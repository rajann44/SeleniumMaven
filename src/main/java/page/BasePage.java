package page;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    static ThreadLocal<ExtentTest> logger;
    public static void setLogger(ThreadLocal<ExtentTest> extentTestThreadLocal) {
        logger = extentTestThreadLocal;
    }

    public void logInfo(String logInfo) {
        logger.get().info(logInfo);
    }

    /**
     * Go to the specified url
     *
     * @param url
     */
    public void gotToURL(String url) {
        driver.get(url);
    }

    /**
     * Refreshes the browser driver
     */
    public void refreshBrowser() {
        driver.navigate().refresh();
    }

    /**
     * This Method is used to drag and drop element
     *
     * @param element
     * @param toElement
     * @throws InterruptedException
     */
    public void dragAndDrop(WebElement element, WebElement toElement) {
        Actions action = new Actions(this.driver);
        action.dragAndDrop(element, toElement).build().perform();
    }

    /**
     * This method will hold shift and click on element
     *
     * @param element
     */
    public void shiftClick(WebElement element) {
        new Actions(this.driver).keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).perform();
    }

    /**
     * Moves to a web element with WebElement
     *
     * @param element
     * @return WebElement
     */
    public WebElement moveToElement(WebElement element) {
        new Actions(this.driver).moveToElement(element).build().perform();
        return element;
    }

}
