package Tests;

import BaseClass.OptionsPlayBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.OptionsPlayForgotPasswordPage;
import utils.*;

@Listeners(ListenerClass.class)

public class OptionsPlayForgotPasswordTest extends OptionsPlayBaseClass {
    private OptionsPlayForgotPasswordPage forgotPasswordPage;
    private GenericMethodsClass genericMethods;

    @BeforeClass
    public void setUpPage() {
        genericMethods = new GenericMethodsClass(driver);
        forgotPasswordPage = new OptionsPlayForgotPasswordPage(driver);
    }

    @Test(priority = 0)
    public void navigateToForgotPasswordPage() throws InterruptedException {
        sleep();
        genericMethods.acceptAlert();
        sleep();
        forgotPasswordPage.clickLoginSignUpButton();
        sleep();
        forgotPasswordPage.clickForgotPasswordLink();
    }

    @Test(priority = 1 , dataProvider = "ForgotPasswordData", dataProviderClass = DataProviderClass.class)
    public void verifyInvalidForgotPassword1(String email) throws InterruptedException {
        forgotPasswordPage.enterEmail(email);
        forgotPasswordPage.clickSendButton();
        sleep();
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(), ConstantsClass.forgotpasswordpageErrorMessage);
        sleep();
        forgotPasswordPage.clearEmail();
    }

    @Test(priority = 2)
    public void verifyInvalidForgotPassword2() throws InterruptedException {
        forgotPasswordPage.enterEmail(ConfigClass.get("email"));
        forgotPasswordPage.clickSendButton();
        sleep();
        Assert.assertEquals(forgotPasswordPage.getErrorMessage(), ConstantsClass.forgotpasswordpageErrorMessage);
        sleep();
        forgotPasswordPage.clearEmail();
    }

    @Test(priority = 3)
    public void takeScreenshot() {
        genericMethods.takeScreenshot(ConstantsClass.screenshotPath);
    }
}
