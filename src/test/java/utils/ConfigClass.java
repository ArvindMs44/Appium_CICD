package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(ConstantsClass.propertiesPath);
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
