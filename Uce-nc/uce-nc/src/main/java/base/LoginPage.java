package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "accountName") private WebElement accountNameField;
    @FindBy(id = "userName") private WebElement usernameField;
    @FindBy(id = "password") private WebElement passwordField;
    @FindBy(id = "btnLogin") private WebElement loginButton;
    
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterAccountName(String accountName) {
        accountNameField.sendKeys(accountName);
        return this;
    }

    public LoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public CampaignsPage clickLoginButton() {
        loginButton.click();
        return new CampaignsPage(driver);
    }
}
