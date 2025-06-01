package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class DynamicDataPage extends ElementUtils {
    private WebDriver driver;
    @FindBy(id = "save")
    private WebElement getDetailsButton;

    @FindBy(xpath = "//div[@id='loading']/img[1]")
    private WebElement dynamicImage;

    public DynamicDataPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickGetDetails() {
        clickElement(getDetailsButton);
    }

    public WebElement waitForDynamicImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement imageElement = wait.until(ExpectedConditions.visibilityOf(dynamicImage));
        return imageElement;
    }

}
