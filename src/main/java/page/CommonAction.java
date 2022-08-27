package page;

import org.openqa.selenium.WebDriver;

public class CommonAction {

    WebDriver driver;

    public CommonAction(WebDriver driver){
        this.driver = driver;
    }

    public void gotToURL(String url){
        driver.get(url);
    }


}
