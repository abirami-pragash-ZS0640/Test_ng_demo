package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class ModalsPage extends ElementUtils {

    private WebDriver driver;
    public ModalsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='#myModal']")
    private WebElement launchSingleModalBtn;

    @FindBy(xpath="(//h4[@class='modal-title'])[1]")
    private WebElement singleModal;

    @FindBy(xpath = "//div[@id='myModal']//a[@class='close']")
    private WebElement closeSingleModalBtn;

    public void clickLaunchSingleModal() {
        clickElement(launchSingleModalBtn);
    }

    public boolean isSingleModalVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOf(singleModal));
            return modal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeSingleModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOf(closeSingleModalBtn));
            clickElement(closeSingleModalBtn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
