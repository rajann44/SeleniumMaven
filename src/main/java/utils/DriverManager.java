package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    protected WebDriver driver = null;

    public WebDriver getDriver(){
        if(driver==null){
            driver = WebDriverManager.chromedriver().create();
        }
        return driver;
    }

}
