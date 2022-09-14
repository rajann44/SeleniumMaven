package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticlePage extends BasePage{

    public ArticlePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className="mw-page-title-main")
    public WebElement articleTitle;

    public void verifyArticleTitle(String title) {
        Assert.assertEquals(articleTitle.getText(), title);
    }

}
