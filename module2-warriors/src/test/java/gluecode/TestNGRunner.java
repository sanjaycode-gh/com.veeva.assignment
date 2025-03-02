package gluecode;

import config.ReportConfig;
import drivers.Context;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "features",
        glue = {"gluecode/stepdefinitions", "commonhooks"},
        plugin = {
                "pretty",
                "json:target/cucumber-reports/cucumber.json", // Generate JSON for reporting
                "html:target/cucumber-html-report"
        },
        monochrome = true
//        tags = "@countFeeds"

)

public class TestNGRunner extends AbstractTestNGCucumberTests {

private static ThreadLocal<String> threadBrowser = new ThreadLocal<>();
    @BeforeClass
    @Parameters({"browser", "cucumberTags", "yamlFilePath"})
    public void setUp(@Optional("chrome") String browser , @Optional("allTests") String cucumberTags, @Optional("testdata/WarriorsTestData.yml") String yamlFilePath) {
        Context.setBrowser(browser);
        Context.setYamlFilePath(yamlFilePath);
        System.setProperty("cucumber.filter.tags", cucumberTags);
//        System.setProperty("logPath", "logs");
    }


    @AfterSuite()
    public void afterSuite(){
        ReportConfig.generateReport();
    }

}
