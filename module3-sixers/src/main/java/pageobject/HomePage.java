package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.SeleniumCommonUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class,'tileHeroStoriesButton')]/div[contains(@class,'tileHeroStoriesButtonTitle')]")
    private List<WebElement> btnSlidesList;

    public int getSlidesCount(){
        logger.info("Getting the count of slides");
        return btnSlidesList.size();
    }

    public List<String> getSlidesTitle(){
        logger.info("Getting the slides title");
        List<String> slideTitlesList = new ArrayList<>();
        try {
            seleniumCommonUtils.waitForElementsToBeVisible(btnSlidesList);
            for (WebElement slide : btnSlidesList) {
                slideTitlesList.add(slide.getText());
            }
        }
        catch (Exception e){
            logger.info("Exception occured while fetching slides title");
            throw new NullPointerException("Failed while fetching slides title");
        }

        return slideTitlesList;
    }
}
