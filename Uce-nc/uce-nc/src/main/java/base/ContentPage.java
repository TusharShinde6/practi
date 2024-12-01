package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentPage extends BasePage {

    @FindBy(xpath = "//button[text()='Create New Template']") private WebElement createNewTemplateButton;

    public CreateTemplatePage clickCreateNewTemplate() {
        createNewTemplateButton.click();
        return new CreateTemplatePage();
    }
}
