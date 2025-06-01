package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicDataPage;
import pages.HomePage;
import pages.MorePage;
import testbase.TestBase;

public class DynamicContentTest extends TestBase {

    @Test(description = "Verify dynamic user data loads")
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
