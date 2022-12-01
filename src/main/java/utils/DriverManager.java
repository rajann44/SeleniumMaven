package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ChromeOptions chromeOptions = new ChromeOptions();
    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void setupDriver(){
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        setDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
    }

}
