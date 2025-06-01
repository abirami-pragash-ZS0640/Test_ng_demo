package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtils;

import java.time.Duration;

public class WindowsPage extends ElementUtils {
    private WebDriver driver;

    @FindBy(xpath = "//button[contains(text(),'click')]")
    private WebElement clickButton;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public WindowsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openTab() {
        WebElement tabBtn = driver.findElement(By.xpath("//a[@href='#Tabbed']"));
        tabBtn.click();

        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOf(clickButton));
            clickElement(clickButton);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void openSeparateWindow() {
        WebElement separateBtn = driver.findElement(By.xpath("(//a[@class='analystic'])[2]"));
        separateBtn.click();
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOf(clickButton));
            clickElement(clickButton);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void openMultipleWindows() {
        WebElement multipleBtn = driver.findElement(By.xpath("//a[@href='#Multiple']"));
        multipleBtn.click();
        try {
            WebElement modal = wait.until(ExpectedConditions.visibilityOf(clickButton));
            clickElement(clickButton);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getWindowCount() {
        return driver.getWindowHandles().size();
    }

}
