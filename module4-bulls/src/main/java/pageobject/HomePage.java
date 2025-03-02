package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BullsConstants;
import utilities.FileUtils;
import utilities.SeleniumCommonUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@data-testid='footer-list-item']/a")
    private List<WebElement> footerHyperLinks;

    public HomePage getFooterHyperLinks(String filename){
        try {
            logger.info("getting footer hyperlinks and saving into csv file");

            new FileUtils().createFile(filename);
            for (WebElement link : footerHyperLinks) {
                String linkText = link.getDomAttribute("href");
                if (linkText != null && !linkText.startsWith("http")) {
                    linkText = BullsConstants.BASE_URL + linkText;
                }
                new FileUtils().writeIntoFile(linkText);
            }

        }
        catch (Exception e){
            logger.info("Error while getting footer hyperlinks and saving into csv file");
            throw new RuntimeException();
        }

        return this;
    }

    public List<String> duplicateHyperLinks(){
        List<String> duplicateLinks = new ArrayList<>();
        Set<String> uniqueLinks = new HashSet<>();

        logger.info("Finding duplicate hyperlinks");
        try {
            for (WebElement link : footerHyperLinks) {
                String linkText = link.getDomAttribute("href");

                if (!uniqueLinks.add(linkText)) {
                    duplicateLinks.add(linkText);
                }
            }
        }
        catch (Exception e){
            logger.info("Error while finding duplicate hyperlinks");
            throw new RuntimeException();
        }
        softAssert.assertTrue(duplicateLinks.isEmpty(), "No duplicate hyperlinks found");
        return duplicateLinks;
    }
}
