package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudiencePage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Overview')]") 
    private WebElement audiencePageText;
    
    @FindBy(xpath = "//a[@data-sit='audience']")  // Assuming this is the link to navigate to Audience page
    private WebElement audienceLink;

    // Constructor to initialize the WebElements using PageFactory
    public AudiencePage(WebDriver driver) {    
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Check if the Audience page is 
    public boolean isAudiencePage() {
        return audiencePageText.isDisplayed();
    }

    // Click on the Audience section and return the AudiencePage object
    public AudiencePage clickAudienceSection() {
        audienceLink.click(); // Click the Audience link
        return new AudiencePage(driver); // Return the AudiencePage instance
    }
}
