package test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;
import pages.MorePage;
import pages.SwitchToPage;
import testbase.TestBase;

@Epic("Automation Testing for Alerts")
@Feature("Alerts Feature")
public class AlertsTest extends TestBase {

    @Test(description = "Verify simple alert handling works")
    @Severity(SeverityLevel.CRITICAL)
    @Story("User handles simple alert properly")
    @Description("This test verifies that the user can successfully interact with a simple JavaScript alert.")
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
    @Severity(SeverityLevel.NORMAL)
    @Story("User handles confirm alert correctly")
    @Description("This test verifies both accept and dismiss actions for a confirm alert.")
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
    @Severity(SeverityLevel.NORMAL)
    @Story("User handles prompt alert input")
    @Description("This test verifies that the user can input text into a prompt alert and validate the returned value.")
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
