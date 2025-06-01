package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class MultipleModalsPage extends ElementUtils {
    private WebDriver driver;
    @FindBy(xpath = "//a[@href='#myModalMulti']")
    private WebElement launchModalBtn;

    @FindBy(xpath = "(//a[@class='btn'])[1]")
    private WebElement ModalCloseBtn;

    @FindBy(xpath = "//a[@href='#myModal2']")
    private WebElement openSecondModalBtn;

    @FindBy(xpath = "//div[@id='myModal2']//button[@class='close']")
    private WebElement secondModalCloseBtn;

    @FindBy(xpath="//h4[text()='First Modal']")
    private WebElement firstModal;

    @FindBy(xpath="//h4[text()='Modal 2']")
    private WebElement secondModal;
    public MultipleModalsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openFirstModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(launchModalBtn));
            clickElement(launchModalBtn);
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        }

    }

    public void closeFirstModal() {
        clickElement(ModalCloseBtn);
    }

    public boolean isFirstModalVisible() {
        //return firstModal.isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.visibilityOf(firstModal));
            return firstModal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void openSecondModal() {
        clickElement(openSecondModalBtn);
    }

    public void closeSecondModal() {
        clickElement(secondModalCloseBtn);
    }

    public boolean isSecondModalVisible() {
       // return secondModal.isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(secondModal));
            return secondModal.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
