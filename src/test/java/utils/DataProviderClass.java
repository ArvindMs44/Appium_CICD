package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "ForgotPasswordData")
    public Object[][] ForgotPasswordData() {
        return new Object[][]{
                {"username1"},
                {"username2"},
                {"username3"},
        };
    }
}
