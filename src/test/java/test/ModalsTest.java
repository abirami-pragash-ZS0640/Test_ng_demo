package test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ModalsPage;
import pages.MorePage;
import pages.MultipleModalsPage;
import testbase.TestBase;
@Epic("Automation Testing for Modals")
@Feature("Modal Dialog Handling")
public class ModalsTest extends TestBase {

    @Test(description = "Verify single modal handling works")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User interacts with a single modal")
    @Description("This test ensures that a single modal can be launched and closed correctly.")

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

    @Test(description = "Verify multiple modal handling works")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User interacts with nested or multiple modals")
    @Description("This test ensures that multiple modals (nested modals) can be opened and closed in the correct order.")
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
