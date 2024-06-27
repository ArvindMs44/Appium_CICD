package BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSStartScreenRecordingOptions;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.ConstantsClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OptionsPlayBaseClass {
    private AppiumDriverLocalService service;
    public static AppiumDriver<MobileElement> driver;
    private DesiredCapabilities android_capabilities;
    private DesiredCapabilities ios_capabilities;

    @BeforeClass(alwaysRun = true)
    @Parameters("platform")
    public void setUp(@Optional("android") String platform) throws Exception {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(ConstantsClass.appiumserverPath))
                .withIPAddress(ConstantsClass.appiumserverIPAddress).usingPort(ConstantsClass.appiumserverPort).build();
                service.start();
        switch (platform.toLowerCase()) {
            case "android":
                android_capabilities = new DesiredCapabilities();
                android_capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ConstantsClass.androidAppPackage);
                android_capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ConstantsClass.androidAppActivity);
                driver = new AndroidDriver<>(new URL(ConstantsClass.appiumserverUrl), android_capabilities);
                ((CanRecordScreen) driver).startRecordingScreen();
                break;
            case "ios":
                ios_capabilities = new DesiredCapabilities();
                ios_capabilities.setCapability(MobileCapabilityType.APP, "/path/to/your.app");
                ios_capabilities.setCapability("xcodeOrgId", "your-xcode-org-id");
                ios_capabilities.setCapability("xcodeSigningId", "iPhone Developer");
                driver = new IOSDriver<>(new URL(ConstantsClass.appiumserverUrl), ios_capabilities);
                ((CanRecordScreen) driver).startRecordingScreen();
                break;
            default:
                throw new IllegalArgumentException("Platform not supported: " + platform);
        }
    }

    @AfterClass
    public void tearDown() throws IOException {
        if (driver != null) {
            String base64String = ((CanRecordScreen)driver).stopRecordingScreen();
            byte[] data = Base64.decodeBase64(base64String);
            String destinationPath = ConstantsClass.screenrecordingPath;
            Path path = Paths.get(destinationPath);
            Files.write(path, data);
            driver.quit();
            service.stop();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void sleep() throws InterruptedException { Thread.sleep(5000); }
}

