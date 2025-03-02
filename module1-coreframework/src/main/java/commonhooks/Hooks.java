package commonhooks;

import config.LogConfig;
import drivers.Context;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import pageobject.BasePage;
import utilities.YamlReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    private WebDriver driver;
    private final Context context;
    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private static final ThreadLocal<Context> testContextThreadLocal = new ThreadLocal<>(); // added
    public Hooks(Context context){
        this.context = context;
    }


    @Before
    public void initialize(Scenario scenario){
        context.initializeLogFile(scenario);
        testContextThreadLocal.set(context);//added
        LogManager.getLogger(Hooks.class).info("Starting scenario: " + scenario.getName());

//        context.initializeLogging(scenario);
        String browser = Context.getBrowser();
        driver = DriverFactory.initializeDriver(browser);
        context.driver = driver;
//        logger.info("==== STARTING SCENARIO: " + scenario.getName() + " ====");

    }

    @After
    public void teardown(Scenario scenario){
        driver.quit();
        logger.info("==== ENDING SCENARIO: " + scenario.getName() + " ====");

        if (scenario.isFailed() && driver instanceof TakesScreenshot) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        if (scenario.getName().contains("Adding mens jackets")) {  // Attach only for this scenario
            String filePath = "src/test/java/output.txt";
            try {
                byte[] outputTextFile = Files.readAllBytes(Paths.get(filePath));
                scenario.attach(outputTextFile, "text/plain", "Product_Price_And_Title_Text_File");
            } catch (IOException e) {
                logger.info("failed while attaching the txt file to report");
            }
        }
            ThreadContext.clearAll();
//        // Attach logs to the report
//        try {
//            byte[] logBytes = Files.readAllBytes(Paths.get("logs/execution.log"));
//            scenario.attach(logBytes, "text/plain", "Execution Logs");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        byte[] logBytes = logger.toString().getBytes();
//        scenario.attach(logBytes, "text/plain", "Execution Logs");
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
         // Capture only for failed steps, remove this condition to capture all
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");

    }

}
