package tests;

import base.BasePage;
import pages.WaitPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WaitPageTest extends BasePage {

    @Test
    public void testWaitMessageDisplay() {
        // Navigate to the test page
        driver.get("file:///path/to/your/html/file.html");

        // Initialize WaitPage
        WaitPage waitPage = new WaitPage(driver);

        // Verify wait message is displayed
        Assert.assertTrue(waitPage.isWaitMessageDisplayed(), 
            "Wait message should be visible");
    }

    @Test
    public void testWaitMessageContent() {
        // Navigate to the test page
        driver.get("file:///path/to/your/html/file.html");

        // Initialize WaitPage
        WaitPage waitPage = new WaitPage(driver);

        // Verify wait message content
        String expectedMessage = "Please wait...";
        Assert.assertEquals(waitPage.getWaitMessage(), expectedMessage, 
            "Wait message content does not match");
    }
}