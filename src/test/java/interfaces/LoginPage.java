package interfaces;

public interface LoginPage {

    public void enterUsername(String username);

    public void enterPassword(String password);

    public void clickLoginButton();

    public void clickBackButton();

    public void clickLoginSignUpButton();

    public void clickallowButton();

    public String getErrorMessage();

}
