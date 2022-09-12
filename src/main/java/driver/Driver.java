package driver;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;

import utils.PropertyUtils;

import java.util.Objects;

public final class Driver {


    private Driver(){

    }

    public static void initDriver(String browser) throws Exception {
        if(Objects.isNull(DriverManager.getDriver())){
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                DriverManager.setDriver(new ChromeDriver());
            }else  if(browser.equalsIgnoreCase("firefox")){
                //WebDriverManager.firefoxdriver().setup();
                //DriverManager.setDriver(new FirefoxDriver());
            }else{
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
                DriverManager.setDriver(new ChromeDriver());
            }




            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }

    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
