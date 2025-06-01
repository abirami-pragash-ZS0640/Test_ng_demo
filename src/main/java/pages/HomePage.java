package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class HomePage extends ElementUtils {

    //private final By skipSignInButton = By.id("btn2");

    @FindBy(id = "btn2")
    private WebElement skipSignInButton;
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickSkipSignIn() {
        clickElement(skipSignInButton);
    }

}
