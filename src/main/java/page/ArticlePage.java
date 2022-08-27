package page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageLocator.ArticleLocator;
import utils.ElementFetch;

public class ArticlePage {

    WebDriver driver;
    ElementFetch elementFetch = new ElementFetch();

    public ArticlePage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyArticleTitle(String title) {
        Assert.assertEquals(elementFetch.getWebElement(driver, "CLASS", ArticleLocator.articleTitle).getText(), title);
    }

}
