package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class ElementFetch{

    public WebElement getWebElement(WebDriver driver, String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return driver.findElement(By.id(identifierValue));
            case "CSS":
                return driver.findElement(By.cssSelector(identifierValue));
            case "TAGNAME":
                return driver.findElement(By.tagName(identifierValue));
            case "XPATH":
                return driver.findElement(By.xpath(identifierValue));
            case "CLASS":
                return driver.findElement(By.className(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListOfWebElement(WebDriver driver, String identifierType, String identifierValue){
        switch (identifierType){
            case "ID":
                return driver.findElements(By.id(identifierValue));
            case "CSS":
                return driver.findElements(By.cssSelector(identifierValue));
            case "TAGNAME":
                return driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return driver.findElements(By.xpath(identifierValue));
            default:
                return Collections.emptyList();
        }
    }

}
