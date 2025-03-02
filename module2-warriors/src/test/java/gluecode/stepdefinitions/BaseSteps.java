package gluecode.stepdefinitions;

import drivers.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.YamlReader;

import java.util.List;
import java.util.Map;

public class BaseSteps {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseSteps.class);
    protected final Context context;

    public BaseSteps(Context context){
        driver = context.driver;
        this.context = context;

    }


}
