package utils;

import config.GSheetKeys;
import helper.HttpHandler;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ChromeOptions chromeOptions = new ChromeOptions();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(HttpHandler.getTestDataFromSheet(GSheetKeys.implicitWAIT))));
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void setupDriver(){
        if (HttpHandler.getTestDataFromSheet(GSheetKeys.headlessMode).contains("yes")) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        setDriver(WebDriverManager.chromedriver().capabilities(chromeOptions).create());
    }

}
