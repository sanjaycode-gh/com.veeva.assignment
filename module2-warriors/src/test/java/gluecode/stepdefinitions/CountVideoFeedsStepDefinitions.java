package gluecode.stepdefinitions;

import drivers.Context;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.HomePage;
import pageobject.NewsPage;

public class CountVideoFeedsStepDefinitions extends BaseSteps {

    public CountVideoFeedsStepDefinitions(Context context) {
        super(context);
    }


    @When("user navigates to {string} menu")
    public void navigateToMenuItem(String menu){

        new HomePage(driver).navigateTOThreeDotsSubMenu(context.getYamlValue(menu));
    }

    @Then("user verifies it should be on {string} page")
    public void verifyLandingPage(String page){
        new HomePage(driver).verifyLandingPage(context.getYamlValue(page));

    }

    @Then("user counts total number of {string} feeds")
    public void countFeeds(String typeOfFeed){
        new NewsPage(driver).countFeeds(context.getYamlValue(typeOfFeed));
    }

    @Then("user counts total number of {string} feeds present in page >= {string}")
    public void countFeeds(String typeOfFeed, String time){
        new NewsPage(driver).countFeedsGE(context.getYamlValue(typeOfFeed), context.getYamlValue(time));
    }

}
