package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Logger;

public class SeleniumCommonUtils {

    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(SeleniumCommonUtils.class.getName());

    public SeleniumCommonUtils(WebDriver driver){
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    public SeleniumCommonUtils switchToWindows(String windowUrl){
        try{
            String parentWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            for (String window : windows) {
                driver.switchTo().window(window);
                if (driver.getCurrentUrl().equals(windowUrl)) {
                    break;
                }
                else{
                    driver.switchTo().window(parentWindow);
                }
            }
        }
        catch (NoSuchWindowException e){
            logger.info("Window could not be found with the url: " + windowUrl);
            throw new RuntimeException(e);
        }

        return this;
    }

    public List<WebElement> waitForElementsToBeVisible(List<WebElement> elementList){
        try{
            return wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        }
        catch (TimeoutException e){
            throw new RuntimeException(e);
        }

    }
    public WebElement waitForElementToBeClickable(WebElement element){
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean waitForElementToBeInvisible(WebElement element){
        try{
            return wait.until(ExpectedConditions.invisibilityOf(element));
        }
        catch (TimeoutException e){
            throw new RuntimeException(e);
        }

    }

    public WebElement getDynamicXpath(String xpath, String... replacementText){
        String xpathString = String.format(xpath, replacementText);
        WebElement element = null;
        try{
            element = driver.findElement(By.xpath(xpathString));
        }
        catch (NoSuchElementException e){
            logger.info("Element could not be found with the xpath: " + xpathString);
        }
        return element;
    }

    public List<WebElement> getDynamicXpathForElements(String xpath, String... replacementText){
        String xpathString = String.format(xpath, replacementText);
        List<WebElement> elements = null;
        try{
            elements = driver.findElements(By.xpath(xpathString));
        }
        catch (NoSuchElementException e){
            logger.info("Element could not be found with the xpath: " + xpathString);
        }
        return elements;
    }

    public SeleniumCommonUtils moveCursorToElement(WebElement element){
        try {
           Actions actions = new Actions(driver);
              actions.moveToElement(element).build().perform();
        }
        catch (ElementClickInterceptedException e){
            logger.info("Element is not scrolled: " + element);
        }
        return this;
    }
    public SeleniumCommonUtils moveToElementAndClick(WebElement element){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
        }
        catch (ElementClickInterceptedException e){
            logger.info("Element is not clickable: " + element);
        }
        return this;
    }

    public SeleniumCommonUtils scrollToEnd(){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        }
        catch (ElementClickInterceptedException e){
            logger.info("Element is not scrolled to end: " +e);
        }
        return this;
    }

    public SeleniumCommonUtils clickCtrlMinus(){
        try {
            Actions actions = new Actions(driver);
            actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).  perform();
        }
        catch (ElementClickInterceptedException e){
            logger.info("Element is not clicked: " +e);
        }
        return this;
    }
}
