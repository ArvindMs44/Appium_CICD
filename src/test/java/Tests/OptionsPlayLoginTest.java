package Tests;

import BaseClass.OptionsPlayBaseClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.OptionsPlayLoginPage;
import utils.ConfigClass;
import utils.ConstantsClass;
import utils.GenericMethodsClass;
import utils.ListenerClass;
import java.io.IOException;
import static utils.ExcelClass.*;

@Listeners(ListenerClass.class)

public class OptionsPlayLoginTest extends OptionsPlayBaseClass {
    private OptionsPlayLoginPage loginPage;
    private GenericMethodsClass genericMethods;

    @BeforeClass
    public void setUpPage() {
        loginPage = new OptionsPlayLoginPage(driver);
        genericMethods = new GenericMethodsClass(driver);
    }

    @Test(priority = 0)
    public void navigateToLoginPage() throws InterruptedException {
        sleep();
        genericMethods.acceptAlert();
        sleep();
        loginPage.clickLoginSignUpButton();
        sleep();
    }

    @Test(priority = 1)
    public void verifyInvalidLogin1() throws InterruptedException {
        loginPage.enterUsername("username");
        loginPage.enterPassword("password");
        loginPage.clickLoginButton();
        sleep();
        Assert.assertEquals(loginPage.getErrorMessage(), ConstantsClass.loginpageErrorMessage);
        loginPage.clickBackButton();
        sleep();
    }

    @Test(priority = 2)
    public void verifyInvalidLogin2() throws InterruptedException, IOException {
        loginPage.clickLoginSignUpButton();
        sleep();
        setExcelFile(ConstantsClass.excelFilePath, ConstantsClass.sheetName);
        String username = getCellData(1, 0);
        String password = getCellData(1, 1);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        sleep();
        Assert.assertEquals(loginPage.getErrorMessage(), ConstantsClass.loginpageErrorMessage);
        sleep();
        setCellData("PASS",2,2,ConstantsClass.excelFilePath);
        loginPage.clickBackButton();
        sleep();
    }

    @Test(priority = 3)
    public void verifyInvalidLogin3() throws InterruptedException, IOException {
        loginPage.clickLoginSignUpButton();
        sleep();
        loginPage.enterUsername(ConfigClass.get("username"));
        loginPage.enterPassword(ConfigClass.get("password"));
        loginPage.clickLoginButton();
        sleep();
        Assert.assertEquals(loginPage.getErrorMessage(), ConstantsClass.loginpageErrorMessage);
    }

    @Test(priority = 4)
    public void takeScreenshot() {
        genericMethods.takeScreenshot(ConstantsClass.screenshotPath);
    }
}
