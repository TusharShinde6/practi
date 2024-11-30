package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Campaigns')]") private WebElement campaignsPageText;
    
    @FindBy(xpath = "//a[@data-sit='audience']")  // Assuming this is the link to navigate to Audience page
    private WebElement audienceLink;

    public boolean isCampaignsPage() {
        return campaignsPageText.isDisplayed();
    }

    public ContentPage clickContentSection() {
        // Assuming Content section is a link
        WebElement contentLink = driver.findElement(By.xpath("//a[@data-sit=\"content\"]"));
        contentLink.click();
        return new ContentPage();
    }
  
    
    public CampaignsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public AudiencePage clickAudienceSection() {
        audienceLink.click(); // Click the Audience link
        return new AudiencePage(driver); // Return the AudiencePage instance
    }
}
