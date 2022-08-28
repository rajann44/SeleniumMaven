package page;

import org.openqa.selenium.WebDriver;
import pageLocator.HomePageLocator;
import utils.ElementFetch;

public class HomePage extends BasePage{

    WebDriver driver;
    ElementFetch elementFetch = new ElementFetch();

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void searchInWikiInputBox(String query){
        logInfo("Verify Wiki Search Works");
        elementFetch.getWebElement(driver, "ID", HomePageLocator.searchInputBox).click();
        elementFetch.getWebElement(driver, "ID", HomePageLocator.searchInputBox).sendKeys(query);
        elementFetch.getWebElement(driver, "XPATH", HomePageLocator.searchButton).click();
    }

}
