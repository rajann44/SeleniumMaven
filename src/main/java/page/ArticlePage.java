package page;

import helper.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageLocator.ArticleLocator;
import utils.ElementFetch;

public class ArticlePage extends BasePage{

    WebDriver driver;
    ElementFetch elementFetch = new ElementFetch();

    public ArticlePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void verifyArticleTitle(String title) {
        Assert.assertEquals(elementFetch.getWebElement(driver, "CLASS", ArticleLocator.articleTitle).getText(), title);
    }

}
