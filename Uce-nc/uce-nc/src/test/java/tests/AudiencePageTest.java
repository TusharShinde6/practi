package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import base.AudiencePage;
import base.BasePage;
import base.CampaignsPage;
import base.LoginPage;
import dev.failsafe.internal.util.*;

public class AudiencePageTest {

	private LoginPageTest loginPageTest;

    @BeforeClass
    public void setUp() {
        loginPageTest = new LoginPageTest();
        loginPageTest.setUp();  // Initialize base page and login page
    }
    
    @Test
    public void testLoginAndNavigateToAudience() {
        // Reuse the login method from LoginPageTest
        CampaignsPage campaignsPage = loginPageTest.login();

        // Verify we are on the correct Campaigns page
        Assert.assertTrue(campaignsPage.isCampaignsPage(), "Campaigns");

        AudiencePage audiencePage = campaignsPage.clickAudienceSection();

        // Verify we are on the 'Audience' page
        Assert.assertTrue(audiencePage.isAudiencePage(), "Audience page did not load properly");
    }
    @AfterClass
    public void tearDown() {
        loginPageTest.tearDown();  // Call tearDown method from LoginPageTest to close the driver
    }


    
    

}
