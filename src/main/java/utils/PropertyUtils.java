package utils;

import constants.FrameworkConstants;
import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class PropertyUtils {

    private PropertyUtils(){

    }

    private static Properties property = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    static {
        try{
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);

            for(Object key : property.keySet()){
                CONFIGMAP.put(String.valueOf(key),String.valueOf(property.get(key)).trim());
            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String get(ConfigProperties key) throws Exception{
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new Exception("Property name "+ key + " is not found. Please check config.properties");
        }

        return CONFIGMAP.get(key.name().toLowerCase());
    }

    public static String getValue(String key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(property.getProperty(key))){
            throw new Exception("Property name "+ key + " is not found. Please check config.properties");
        }else{
            return property.getProperty(key);
        }

    }
}
