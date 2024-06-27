package pages;

import interfaces.ForgotPasswordPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class OptionsPlayForgotPasswordPage implements ForgotPasswordPage {

    private AppiumDriver<MobileElement> driver;

    public OptionsPlayForgotPasswordPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(className = "android.widget.EditText")
    @iOSXCUITFindBy(iOSClassChain = "username")
    private MobileElement emailField;

    @AndroidFindBy(accessibility = "Send")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement sendButton;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement allowButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You have entered an invalid email address!\"]")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement errorMessage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login/Sign up\"]")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement loginsignupButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forgot Password?\"]")
    @iOSXCUITFindBy(accessibility = "loginButton")
    private MobileElement forgotPasswordLink;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    @Override
    public void clearEmail() {
        emailField.clear();
    }

    @Override
    public void clickSendButton() {
        sendButton.click();
    }

    @Override
    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
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


