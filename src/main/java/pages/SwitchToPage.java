package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class SwitchToPage extends ElementUtils {
    private WebDriver driver;
    @FindBy(xpath = "//a[text()='SwitchTo']")
    private WebElement moreMenu;

    @FindBy(xpath = "//a[text()='Alerts']")
    private WebElement alertsLink;

    @FindBy(xpath = "//a[text()='Windows']")
    private WebElement windowsLink;

    //constructor
    public SwitchToPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void goToAlertsPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreMenu).perform();
        clickElement(alertsLink);
    }

    public void goToWindowsPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreMenu).perform();
        clickElement(windowsLink);
    }
}
