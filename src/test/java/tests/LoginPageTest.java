package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.AudiencePage;
import base.BasePage;
import base.CampaignsPage;
import base.ContentPage;
import base.CreateTemplatePage;
import base.LoginPage;

public class LoginPageTest {

    private BasePage basePage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage();
        basePage.setUp();
        loginPage = new LoginPage(basePage.getDriver());
        basePage.navigateTo("https://login-pod2.netcoresmartech.com/");
    }
    
    public CampaignsPage login() {
        return loginPage.enterAccountName("pod2_email_tushar")
                        .enterUsername("admin")
                        .enterPassword("Sm@rt@50")
                        .clickLoginButton();
    }

    @Test
    public void testLoginAndNavigate() {
    	CampaignsPage campaignsPage = login();
        // Login steps
//        CampaignsPage campaignsPage = loginPage.enterAccountName("pod2_email_tushar")
//                                               .enterUsername("admin")
//                                               .enterPassword("Sm@rt@50")
//                                               .clickLoginButton();

//        // Verify we are on the correct page
        Assert.assertTrue(campaignsPage.isCampaignsPage(), "Campaigns");
        
//
//        // Navigate through the content section and create a new template
//        ContentPage contentPage = campaignsPage.clickContentSection();
//        CreateTemplatePage createTemplatePage = contentPage.clickCreateNewTemplate();
//
//        // Verify we are on the 'Create Template' page
//        Assert.assertTrue(createTemplatePage.isTemplateCreationPage(), "Create Template page did not load properly");
    }

    @AfterClass
    public void tearDown() {
        basePage.tearDown();
    }
}
