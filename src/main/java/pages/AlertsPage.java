package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class AlertsPage extends ElementUtils {
    private WebDriver driver;

    // --- Tab navigation ---
    @FindBy(xpath = "//a[text()='Alert with OK ']")
    private WebElement alertWithOKTab;

    @FindBy(xpath = "//a[text()='Alert with OK & Cancel ']")
    private WebElement alertWithOKCancelTab;

    @FindBy(xpath = "//a[text()='Alert with Textbox ']")
    private WebElement alertWithTextboxTab;

    // --- Buttons ---
    @FindBy(xpath = "//button[@onclick='alertbox()']")
    private WebElement simpleAlertButton;

    @FindBy(xpath = "//button[@onclick='confirmbox()']")
    private WebElement confirmAlertButton;

    @FindBy(xpath = "//button[@onclick='promptbox()']")
    private WebElement promptAlertButton;

    // --- Result Text (for Prompt alert) ---
    @FindBy(id = "demo1")
    private WebElement promptResultText;

    // --- Constructor ---
    public AlertsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // --- Tab navigation methods ---
    public void clickSimpleAlertTab() {
        clickElement(alertWithOKTab);
    }

    public void clickConfirmAlertTab() {
        clickElement(alertWithOKCancelTab);
    }

    public void clickPromptAlertTab() {
        clickElement(alertWithTextboxTab);
    }

    // --- Alert handlers ---
    public String handleSimpleAlert() {
        clickElement(simpleAlertButton);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        alert.accept();
        return text;
    }

    public String handleConfirmAlert(boolean accept) {
        clickElement(confirmAlertButton);
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
        return text;
    }

    public String handlePromptAlert(String inputText) {
        clickElement(promptAlertButton);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(inputText);
        alert.accept();
        return promptResultText.getText();
    }
}
