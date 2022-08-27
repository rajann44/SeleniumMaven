package page;

import org.openqa.selenium.WebDriver;
import pageLocator.HomePageLocator;
import utils.ElementFetch;

public class HomePage {

    WebDriver driver;
    ElementFetch elementFetch = new ElementFetch();

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchInWikiInputBox(String query){
        elementFetch.getWebElement(driver, "ID", HomePageLocator.searchInputBox).click();
        elementFetch.getWebElement(driver, "ID", HomePageLocator.searchInputBox).sendKeys(query);
        elementFetch.getWebElement(driver, "XPATH", HomePageLocator.searchButton).click();
    }

}
