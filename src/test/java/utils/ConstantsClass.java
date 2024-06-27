package utils;

public class ConstantsClass {

    public static String forgotpasswordpageErrorMessage = "You have entered an invalid email address!";
    public static String loginpageErrorMessage = "You have entered an invalid username or password";
    public static String appiumserverPath = System.getProperty("user.dir")+"/npm/node_modules/appium/build/lib/main.js";
    public static String appiumserverIPAddress = "127.0.0.1";
    public static int appiumserverPort = 4723;
    public static String appiumserverUrl = "http://localhost:4723/wd/hub";
    public static String screenrecordingPath = System.getProperty("user.dir")+"/src/main/resources/videos/screenrecording.mp4";
    public static String androidAppPackage = "com.optionsplay.app";
    public static String androidAppActivity = "com.optionsplay.app.MainActivity";
    public static String excelFilePath = System.getProperty("user.dir")+"/src/main/resources/excel/TestData.xls";
    public static String sheetName = "Sheet1";
    public static String screenshotPath = System.getProperty("user.dir")+"/src/main/resources/screenshots/screenshot.png";
    public static String propertiesPath = System.getProperty("user.dir")+"/src/main/resources/properties/config.properties";

}