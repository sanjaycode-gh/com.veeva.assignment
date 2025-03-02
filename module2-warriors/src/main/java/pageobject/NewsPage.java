package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utilities.SeleniumCommonUtils;
import utilities.WarriorsDynamicLocators;

public class NewsPage extends BasePage{

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void countFeeds(String typeOfFeed){
        logger.info("Generating the dynamic element from the xpath by passing the type of feed");
       long feedsCount =  seleniumCommonUtils.getDynamicXpathForElements(WarriorsDynamicLocators.BTN_ARTICLE_RESULTS, typeOfFeed).size();
        logger.info(typeOfFeed + " feed count is " + feedsCount);
    }

    public void countFeedsGE(String typeOfFeed,String value){
        value = value.replaceAll("[A-Za-z]","");
        long feedsCount =  new SeleniumCommonUtils(driver).getDynamicXpathForElements(WarriorsDynamicLocators.TEXT_ARTICLE_RESULTS_GE, typeOfFeed, value).size();
        logger.info( typeOfFeed + " feeds count greater than " + value + " days is " +feedsCount);
    }
}
