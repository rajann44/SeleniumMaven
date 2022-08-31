package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ChromeOptions options = new ChromeOptions();
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void setupDriver(String browserName){
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--remote-debugging-port=9222");
        switch (browserName){
            case "chrome":
                //setDriver(WebDriverManager.chromedriver().create());
                setDriver(WebDriverManager.chromedriver().capabilities(options).create());
                break;
            case "firefox":
                setDriver(WebDriverManager.firefoxdriver().create());
                break;
            case "headless":
                options.addArguments("--headless");
                setDriver(WebDriverManager.chromedriver().capabilities(options).create());
                break;
            default:
                try { throw new Exception("Pass Correct Browser to Run Tests"); }
                catch (Exception e) { throw new RuntimeException(e); }
        }
    }

}
