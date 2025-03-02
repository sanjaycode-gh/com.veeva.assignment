package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FileUtils;
import utilities.SeleniumCommonUtils;
import utilities.WarriorsDynamicLocators;

import java.time.Duration;
import java.util.List;

public class ShopPage extends BasePage{

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@role='button' and text()='Men']")
    private WebElement btnMensMenu;

    @FindBy(xpath = "//span[text()='Jackets']/parent::a")
    private WebElement radioBtnJackets;

    @FindBy(xpath = "//div[@class='product-card-title']/a")
    private List<WebElement> productsTitleList;

    @FindBy(xpath = "//span[@class='lowest']/descendant::span[@class='sr-only'][1]")
    private List<WebElement> productsPricesList;

    @FindBy(xpath = "//a[@data-trk-id='next-page']")
    private WebElement btnNextPage;


    public void filterJackets(String subMenu, String product) throws InterruptedException {
        logger.info("Selecting the product " + product +" from the sub menu " + subMenu);

        WebElement subMenuElement = seleniumCommonUtils.getDynamicXpath(WarriorsDynamicLocators.BTN_SUBMENU, subMenu);

            try {
                seleniumCommonUtils.waitForElementToBeClickable(subMenuElement).click();
            }
            catch (ElementClickInterceptedException e){
                Thread.sleep(5000);
                seleniumCommonUtils.waitForElementToBeClickable(subMenuElement).click();
            }

        WebElement productElement = seleniumCommonUtils.getDynamicXpath(WarriorsDynamicLocators.RADIOBTN_PRODUCT,product);
        try {
            logger.info("Selecting the product " + product);
            seleniumCommonUtils.waitForElementToBeClickable(productElement).click();


        } catch (ElementClickInterceptedException e){
            Thread.sleep(2000);
        }
    }

    public void writeProductDetailsIntoTextFile(){

        logger.info("Writing the product priice and title details into txt file");
        new FileUtils().createFile("output.txt");

        seleniumCommonUtils.waitForElementsToBeVisible(productsTitleList);
        seleniumCommonUtils.waitForElementsToBeVisible(productsPricesList);

        try {

            String flag;
            while (true) {
                for (int i = 0; i < productsTitleList.size(); i++) {
                    new FileUtils().writeIntoFile(productsTitleList.get(i).getText(), productsPricesList.get(i).getText());
                }
                flag = btnNextPage.getDomAttribute("aria-disabled");
                assert flag != null;
                if (flag.equals("true")) {
                    break;
                } else {
                    btnNextPage.click();
                }
            }
        }
        catch (Exception e){
            logger.info("Failed while writing the product details into text file: " +e.getMessage());
            throw new RuntimeException();
        }
    }
}
