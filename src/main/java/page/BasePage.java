package page;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    protected JavascriptExecutor javascriptExecutor;
    static ThreadLocal<ExtentTest> logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

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
     * Navigates to the passed url
     */
    public void navigateToTheURL(String url) {
        driver.get(url);
    }

    /**
     * Click the Element
     */
    public void clickElement(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        webElement.click();
    }
    public void clickElement(By webElement) {
        waitForElementToBeClickable(driver.findElement(webElement));
        driver.findElement(webElement).click();
    }

    /**
     * Right-click the Element
     */
    public void rightClickElement(By selector) {
        action.contextClick(driver.findElement(selector)).build().perform();
    }

    /**
     * Send Value to the passed element
     *
     * @param webElement
     * @param value
     */
    public void sendValuesToElement(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    /**
     * Checks whether a web element is displayed or not
     *
     * @param element
     * @return boolean value
     */
    public boolean isElementDisplayed(By element) {
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        }
    }

    /**
     * Moves to a web element (Mouse gesture)
     *
     * @param element
     * @return WebElement
     */
    public WebElement moveToElement(WebElement element) {
        action.moveToElement(element).build().perform();
        return element;
    }

    /**
     * Wait until element is visible
     *
     * @param element
     * @return WebElement
     */
    public WebElement waitForElementToBeVisible(WebElement element) {
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    /**
     * Wait until element is Clickable
     *
     * @param element
     * @return WebElement
     */
    public WebElement waitForElementToBeClickable(WebElement element) {
        wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    /**
     * Clicks on a web element using JavaScript
     *
     * @param element
     */
    public void jsClick(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * Wait until element is invisible
     *
     * @param element
     */
    public void waitForInvisibilityOf(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    /**
     * Wait until element is present in DOM
     *
     * @param selector
     */
    public WebElement waitForPresenceOfElement(By selector) {
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    /**
     * This Method is used to drag and drop element
     *
     * @param element
     * @param toElement
     * @throws InterruptedException
     */
    public void dragAndDrop(WebElement element, WebElement toElement) {
        action.dragAndDrop(element, toElement).build().perform();
    }

    /**
     * This method will nap for x sceonds
     * @param sec
     */
    public void napFor(int sec) {
        int time = sec * 1000;
        try{
            Thread.sleep(time);
        }catch (Exception exception){}
    }

}
