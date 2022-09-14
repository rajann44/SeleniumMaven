package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="searchInput")
    public WebElement searchInputBox;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement searchButton;

    //Search on Wiki
    public void searchInWikiInputBox(String query){
        logInfo("Verify Wiki Search Works");
        clickElement(searchInputBox);
        sendValuesToElement(searchInputBox,query);
        clickElement(searchButton);
    }

}
