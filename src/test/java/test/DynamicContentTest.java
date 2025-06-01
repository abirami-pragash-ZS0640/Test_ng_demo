package test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicDataPage;
import pages.HomePage;
import pages.MorePage;
import testbase.TestBase;
@Epic("Automation Testing for Dynamic Content")
@Feature("Dynamic Data Feature")
public class DynamicContentTest extends TestBase {

    @Test(description = "Verify dynamic user data loads correctly")
    @Severity(SeverityLevel.NORMAL)
    @Story("User retrieves and sees dynamic content")
    @Description("This test verifies that when the 'Get Details' button is clicked, a dynamically loaded user image appears.")

    public void testDynamicUserDetails() {
        HomePage homePage = new HomePage(driver);
        homePage.clickSkipSignIn();

        MorePage morePage = new MorePage(driver);
        morePage.goToDynamicDataPage();

        DynamicDataPage dynamicDataPage = new DynamicDataPage(driver);
        dynamicDataPage.clickGetDetails();
        WebElement imageElement = dynamicDataPage.waitForDynamicImage();
        Assert.assertTrue(imageElement.isDisplayed());
    }
}
