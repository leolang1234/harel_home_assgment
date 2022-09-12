package constants;

import enums.ConfigProperties;
import utils.PropertyUtils;

import java.io.File;

public final class FrameworkConstants {

    private FrameworkConstants(){

    }
    private static final String RESOURCESPATH = System.getProperty("user.dir")+ File.separator+"src"+
            File.separator+"test"+File.separator+"resources"+File.separator;
    private static final String CHROMEDRIVERPATH = RESOURCESPATH+"executables"+File.separator+"chromedriver";

    private static final String CONFIGFILEPATH = RESOURCESPATH+ "config"+File.separator+"config.properties";

    private static int EXPLICITWAIT = 10;

    public static String getChromeDriverPath(){
        return CHROMEDRIVERPATH;
    }

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }

    public static Integer getExplicitWait(){return EXPLICITWAIT;}


}
