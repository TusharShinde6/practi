package base;

public class CreateTemplatePage extends BasePage {

    // Define the elements related to the 'Create Template' page here, e.g., name, description, etc.
    
    public boolean isTemplateCreationPage() {
        // Check if the page is loaded by verifying some page-specific element
        return driver.getTitle().contains("Create Template");
    }
}
