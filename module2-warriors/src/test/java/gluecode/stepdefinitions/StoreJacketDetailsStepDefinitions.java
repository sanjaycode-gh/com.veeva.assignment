package gluecode.stepdefinitions;

import commonhooks.Hooks;
import drivers.Context;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobject.HomePage;
import pageobject.ShopPage;
import utilities.SeleniumCommonUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StoreJacketDetailsStepDefinitions extends BaseSteps{



    public StoreJacketDetailsStepDefinitions(Context context){
        super(context);
    }

    @Given("user is on warriors Homepage {string}")
    public void navigateToURL(String url){
        try {
            logger.info("Navigating to URL: " + context.getYamlValue(url));
            String value = context.getYamlValue(url);
            driver.get(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed naviation to URL: " + context.getYamlValue(url) + e.getMessage());
        }
    }

    @When("user navigates to shopping menu")
    public void navigateToShoppingMenu(){
        new HomePage(driver).navigateToShoppingMenu();
    }

    @Then("user verifies it should be on warriors shopping page")
    public void verifyShoppingPage(){
        new SeleniumCommonUtils(driver).switchToWindows("https://shop.warriors.com/");
    }

    @When("user searches for all the {string} {string}")
    public void searchMensJackets(String subMenu, String product) throws InterruptedException {
        new ShopPage(driver).filterJackets(context.getYamlValue(subMenu), context.getYamlValue(product));
    }

    @Then("user saves products title and price details into a text file")
    public void saveJacketDetailsIntoTextFile(){

        new ShopPage(driver).writeProductDetailsIntoTextFile();


    }
}
