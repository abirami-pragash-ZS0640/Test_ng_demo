package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class MorePage extends ElementUtils {
    private WebDriver driver;
    @FindBy(xpath = "//a[text()='More']")
    private WebElement moreMenu;

    @FindBy(xpath = "//a[text()='Dynamic Data']")
    private WebElement dynamicDataLink;

    @FindBy(xpath = "//a[text()='Modals']")
    private WebElement modalsLink;

    public MorePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToDynamicDataPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreMenu).perform();
        clickElement(dynamicDataLink);
    }

    public void goToModalsPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreMenu).perform();
        clickElement(modalsLink);
    }
}
