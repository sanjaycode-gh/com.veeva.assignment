package gluecode.stepdefinitions;

import drivers.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import utilities.SeleniumCommonUtils;

public class FindingDuplicateHyperlinksStepDefinitions extends BaseSteps{

    public FindingDuplicateHyperlinksStepDefinitions(Context context) {
        super(context);
    }

    @Given("user is on bulls homepage {string}")
    public void navigateToURL(String url){
        try {
            logger.info("Navigating to URL: " + context.getYamlValue(url));
            String value = context.getYamlValue(url);
            driver.get(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed naviation to URL: " + context.getYamlValue(url) + e.getMessage());
        }
    }

    @When("user scrolls down to footer section")
    public void scrollToFooter(){
        logger.info("Scrolling to the footer section");
        new SeleniumCommonUtils(driver).scrollToEnd();
    }

    @Then("user finds all the hyperlinks available in the footer and saves into a {string} file")
    public void findFooterHyperLinks(String fileName){

        new HomePage(driver).getFooterHyperLinks(context.getYamlValue(fileName));
    }

    @Then("user verifies for any duplicate hyperlinks")
    public void verifyDuplicateHyperLinks(){
        logger.info("Duplicate Hyperklinks count is --> " + new HomePage(driver).duplicateHyperLinks().size());

    }
}
