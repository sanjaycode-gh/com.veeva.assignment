package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    //Various browser drivers are initialized based on the browser parameter passed

    public static WebDriver initializeDriver(String browser) {

    WebDriver driver;

    browser =browser.toLowerCase().trim();

    URL gridUrl;
         try {
        gridUrl = new URL("http://localhost:4444/wd/hub");
    } catch (
    MalformedURLException e) {
        throw new RuntimeException(e);
    }

    ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setAcceptInsecureCerts(true);
        options.addArguments("--force-device-scale-factor=0.9");
        options.addArguments("--high-dpi-support=0.9");

    FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");
        firefoxOptions.setAcceptInsecureCerts(true);
        firefoxOptions.addArguments("layout.css.devPixelsPerPx", "0.9");

    EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setAcceptInsecureCerts(true);
        edgeOptions.addArguments("--force-device-scale-factor=0.9");
        edgeOptions.addArguments("--high-dpi-support=0.9");


     switch(browser){
        case "chrome" -> driver = new ChromeDriver();
        case "firefox" -> driver = new FirefoxDriver();
        case "edge" -> driver = new EdgeDriver();
        case "remotechrome" -> driver = new RemoteWebDriver(gridUrl, options);
        case "remotefirefox" -> driver = new RemoteWebDriver(gridUrl, firefoxOptions);
        case "remoteedge" -> driver = new RemoteWebDriver(gridUrl, edgeOptions);
        default -> throw new IllegalArgumentException("Invalid Browser parameter passed , cannot initialize the WebDriver" +
                " for the : "+browser);
    }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return driver;
}
}
