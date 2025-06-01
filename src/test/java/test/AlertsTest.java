package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import pages.MorePage;
import pages.SwitchToPage;
import testbase.TestBase;

public class AlertsTest extends TestBase {

    @Test(description = "Verify simple alert handling works")
    public void testSimpleAlert() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.goToAlertsPage();
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.clickSimpleAlertTab();

        String alertText = alertsPage.handleSimpleAlert();

        Assert.assertEquals(alertText.trim(), "I am an alert box!", "Alert text did not match");
    }

    @Test(description = "Verify confirm alert handling works")
    public void testConfirmAlert() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.goToAlertsPage();
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.clickConfirmAlertTab();

        // Accept the alert (click OK)
        String alertText = alertsPage.handleConfirmAlert(true);
        Assert.assertEquals(alertText.trim(), "Press a Button !","Alert text did not match");

        // Dismiss the alert (click Cancel) - to show both paths
        alertText = alertsPage.handleConfirmAlert(false);
        Assert.assertEquals(alertText.trim(), "Press a Button !");

    }


    @Test(description = "Verify prompt alert handling works")
    public void testPromptAlert() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.goToAlertsPage();
        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.clickPromptAlertTab();
        String result = alertsPage.handlePromptAlert("Abi");

        Assert.assertTrue(result.contains("Abi"), "Prompt alert did not return expected result");
    }
}
