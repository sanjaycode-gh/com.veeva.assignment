package pageobject;

import config.LogConfig;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.SeleniumCommonUtils;
import utilities.WarriorsDynamicLocators;

public class HomePage extends BasePage{



    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//div[@role='dialog']//descendant::div[text()='x']")
    private WebElement btnPopupClose;

    @FindBy(xpath = "//li[@class='menu-item']/descendant::span[text()='Shop']")
    private WebElement btnShopMenu;

    @FindBy(xpath = "//a[@rel='noreferrer']/span[text()='...']")
    private WebElement btnThreeDots;


    public void navigateToShoppingMenu(){
        try{
        logger.info("CLosing the popup and navigating to warriors shopping menu");
        btnPopupClose.click();
        btnShopMenu.click();
        }
        catch (ElementClickInterceptedException e){
            btnShopMenu.click();
        }
    }

    public void navigateTOThreeDotsSubMenu(String subMenu){

        logger.info("Navigating to News and Features sub menu");
        btnPopupClose.click();

        seleniumCommonUtils.clickCtrlMinus().moveCursorToElement(btnThreeDots);
        logger.info("Fetching the element using dynamic xpath for sub menu: " + subMenu);

        WebElement element = new SeleniumCommonUtils(driver).getDynamicXpath(WarriorsDynamicLocators.BTN_THREEDOTS_SUBMENU,subMenu);

        try {
            logger.info("Clicking on the submenu");
            seleniumCommonUtils.waitForElementToBeClickable(element);
            seleniumCommonUtils.moveToElementAndClick(element);
        }
        catch (ElementClickInterceptedException e){
            seleniumCommonUtils.moveToElementAndClick(element);
        }
    }

    public void verifyLandingPage(String pageTitle){

        logger.info("verifying the landing page header: " + pageTitle);

        softAssert.assertTrue(new SeleniumCommonUtils(driver).getDynamicXpath(WarriorsDynamicLocators.TEXT_PAGE_TITLE,pageTitle).isDisplayed());

    }

}
