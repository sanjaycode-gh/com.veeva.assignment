package gluecode.stepdefinitions;


import drivers.Context;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BaseSteps {

    protected WebDriver driver;
    protected static final Logger logger = Logger.getLogger(BaseSteps.class.getName());
    protected final  Context context;
    public BaseSteps(Context context){
        driver = context.driver;
        this.context = context;
    }



}


