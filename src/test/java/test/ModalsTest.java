package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ModalsPage;
import pages.MorePage;
import pages.MultipleModalsPage;
import testbase.TestBase;

public class ModalsTest extends TestBase {

    @Test(description = "Verify single modal handling works")
    public void testSingleModalHandling() {

        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        MorePage morePage = new MorePage(driver);
        morePage.goToModalsPage();

        ModalsPage modalsPage = new ModalsPage(driver);

        modalsPage.clickLaunchSingleModal();
        Assert.assertTrue(modalsPage.isSingleModalVisible(), "Single modal is not displayed");
        modalsPage.closeSingleModal();
    }

    @Test(description = "Verify single modal handling works")
    public void testMultipleModalHandling() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        MorePage morePage = new MorePage(driver);
        morePage.goToModalsPage();

        MultipleModalsPage multipleModalsPage = new MultipleModalsPage(driver);

        //Open First Modal
        multipleModalsPage.openFirstModal();
        Assert.assertTrue(multipleModalsPage.isFirstModalVisible(), "First modal is not visible");

        //Open Second Modal
        multipleModalsPage.openSecondModal();
        Assert.assertTrue(multipleModalsPage.isSecondModalVisible(), "Second modal is not visible");

        // Close Second Modal
        multipleModalsPage.closeSecondModal();

        // Close First Modal
        multipleModalsPage.closeFirstModal();
    }
}
