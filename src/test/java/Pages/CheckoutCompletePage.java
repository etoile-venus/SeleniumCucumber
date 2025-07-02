package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage  extends StepDefinition {
    WebDriverWait wait;
    public CheckoutCompletePage(){

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @FindBy(css = "h2[class='complete-header']")
    public WebElement titleElement;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    public void clickOnBackHomeButton(){
        wait.until(ExpectedConditions.elementToBeClickable(backHomeButton));
        backHomeButton.click();
    }
}
