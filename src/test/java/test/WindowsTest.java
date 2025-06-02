package test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
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
@Epic("Automation Testing for Window Handling")
@Feature("Window Switching Feature")
public class WindowsTest extends TestBase {
    @DataProvider(name = "windowTypes")
    public Object[][] windowTypes() {
        return new Object[][] {
                {"tab"},
                {"separate"},
                {"multiple"}  // adjust based on actual behavior
        };
    }

    @Story("User opens and switches between multiple browser windows")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test verifies that browser window switching works correctly for different types: tab, separate, and multiple windows.")
    @Test(dataProvider = "windowTypes", description = "Test window handling for different options")
    public void testWindowHandling(String windowType) {
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
