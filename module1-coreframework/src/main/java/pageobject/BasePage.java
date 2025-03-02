package pageobject;

import config.LogConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.SeleniumCommonUtils;

public class BasePage {

    protected WebDriver driver;
    protected SeleniumCommonUtils seleniumCommonUtils;
    protected SoftAssert softAssert;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        seleniumCommonUtils = new SeleniumCommonUtils(driver);
        softAssert = new SoftAssert();
    }
}
