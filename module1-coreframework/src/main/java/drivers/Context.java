package drivers;

import config.LogConfig;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import utilities.YamlReader;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Context {

//***    context class uses Dependency Injection and ThreadLocal to store and retrieve the browser and yaml file path values

    public WebDriver driver;

    private static ThreadLocal<String> threadBrowser = new ThreadLocal<>();
    private static ThreadLocal<String> yamlFilePath = new ThreadLocal<>();
    private final YamlReader yamlReader;
    private String logFileName;

    public Context(){
        yamlReader = new YamlReader(getYamlFilePath());
    }

    public String getYamlValue(String key) {
        return yamlReader.getValue(key);
    }

    public static void setBrowser(String browser) {
        threadBrowser.set(browser);
    }

    public static String getBrowser() {
        return threadBrowser.get();
    }

    public static String getYamlFilePath() {
        return yamlFilePath.get();
    }

    public static void setYamlFilePath(String filePath) {
        yamlFilePath.set(filePath);
    }

    public static void clearBrowser() {
        threadBrowser.remove();
    }

    public void initializeLogFile (Scenario scenario) {
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        String threadId = String.valueOf(Thread.currentThread().getId());
        String scenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_");

        // Unique log file for each scenario
        this.logFileName = "logs/log_" + timestamp + "_" + scenarioName + "_" + threadId + ".log";

        // Set ThreadContext for Log4j2
        ThreadContext.put("scenarioName", scenarioName);
        ThreadContext.put("threadId", threadId);
    }

    public String getLogFileName () {
        return logFileName;
    }

//    public Scenario getScenario () {
//        return scenario;
//    }

}
