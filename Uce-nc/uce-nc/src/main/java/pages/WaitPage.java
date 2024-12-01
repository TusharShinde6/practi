package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#sfz-wait-message")
    private WebElement waitMessageElement;

    public WaitPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getWaitMessage() {
        wait.until(ExpectedConditions.visibilityOf(waitMessageElement));
        return waitMessageElement.getText();
    }

    public boolean isWaitMessageDisplayed() {
        try {
            return waitMessageElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
