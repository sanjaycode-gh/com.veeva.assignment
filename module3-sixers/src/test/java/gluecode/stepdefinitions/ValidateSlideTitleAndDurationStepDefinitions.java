package gluecode.stepdefinitions;

import drivers.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobject.HomePage;

import java.util.ArrayList;
import java.util.List;



public class ValidateSlideTitleAndDurationStepDefinitions extends BaseSteps{
    public ValidateSlideTitleAndDurationStepDefinitions(Context context) {
        super(context);
    }

    @Given("user is on sixers homepage {string}")
    public void navigateToURL(String url){
        try {
            logger.info("Navigating to URL: " + context.getYamlValue(url));
            String value = context.getYamlValue(url);
            driver.get(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed naviation to URL: " + context.getYamlValue(url) + e.getMessage());
        }

    }

    @Then("user counts number of slides present")
    public void countNumberOfSlides(){
        Assert.assertEquals(new HomePage(driver).getSlidesCount(), 5);
    }

    @Then("user verifies title of each slide with expected title")
    public void verifyTitleOfSlides(List<String> list){

        List<String> valueList = new ArrayList<>();
        list.forEach(k-> valueList.add(context.getYamlValue(k)));

        Assert.assertEquals(new HomePage(driver).getSlidesTitle(), valueList);
    }

    @Then("user verifies the duration of each slide with expected duration")
    public void verifyDurationOfSlides(List<String> list){

//        pending implementation

    }
}
