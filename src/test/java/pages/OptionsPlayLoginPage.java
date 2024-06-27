package pages;

import interfaces.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import javax.lang.model.element.Element;

public class OptionsPlayLoginPage implements LoginPage {

    private AppiumDriver<MobileElement> driver;

    public OptionsPlayLoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"User name*\"]")
    @iOSXCUITFindBy(iOSClassChain = "username")
    private MobileElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Password*\"]")
    @iOSXCUITFindBy(accessibility = "password")
    private MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement allowButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You have entered an invalid username or password\"]")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement errorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login/Sign up\"]")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement loginsignupButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement backButton;


    @Override
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    @Override
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Override
    public void clickLoginButton() {
        loginButton.click();
    }

    @Override
    public void clickBackButton() {
        backButton.click();
    }

    @Override
    public void clickLoginSignUpButton() {
        loginsignupButton.click();
    }

    @Override
    public void clickallowButton() {
        allowButton.click();
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}


