package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SwitchToPage;
import pages.WindowsPage;
import testbase.TestBase;

import java.time.Duration;
import java.util.Set;

public class WindowsTest extends TestBase {
    @DataProvider(name = "windowTypes")
    public Object[][] windowTypes() {
        return new Object[][] {
                {"tab", 2},
                {"separate", 2},
                {"multiple", 3}  // adjust based on actual behavior
        };
    }

    @Test(dataProvider = "windowTypes", description = "Test window handling for different options")
    public void testWindowHandling(String windowType, int expectedWindowCount) {
        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.goToWindowsPage();

        WindowsPage windowsPage = new WindowsPage(driver);

        switch (windowType) {
            case "tab":
                windowsPage.openTab();
                break;
            case "separate":
                windowsPage.openSeparateWindow();
                break;
            case "multiple":
                windowsPage.openMultipleWindows();
                break;
        }

        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        boolean foundExpectedTitle = false;

        for (String handle : handles) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();

            if (title.contains("Selenium") || title.contains("Frames & windows")) {
                foundExpectedTitle = true;
                break;
            }
        }
        Assert.assertTrue(foundExpectedTitle, "Expected window with correct title not found!");
    }
}
