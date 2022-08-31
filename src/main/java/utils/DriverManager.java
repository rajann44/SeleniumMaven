package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ChromeOptions chromeOptions = new ChromeOptions();
    static FirefoxOptions firefoxOptions = new FirefoxOptions();
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void setupDriver(String browserName){
        switch (browserName){
            case "firefox":
                firefoxOptions.addArguments("--headless");
                setDriver(WebDriverManager.firefoxdriver().capabilities(firefoxOptions).create());
                break;
            case "chrome":
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                setDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
                break;
            default:
                try { throw new Exception("Pass Correct Browser to Run Tests"); }
                catch (Exception e) { throw new RuntimeException(e); }
        }
    }

}
