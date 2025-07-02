package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends StepDefinition {
    WebDriverWait wait;
    public CheckoutPage(){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(css = "span[class='title']")
    public WebElement title;

    @FindBy(id = "first-name")
    public WebElement first_name_field;

    @FindBy(id = "last-name")
    public WebElement last_name_field;

    @FindBy(id = "postal-code")
    public WebElement postal_code_field;

    @FindBy(id = "continue")
    public WebElement continueButton;

    public void inputIntoFirstNameField(String txt){
        wait.until(ExpectedConditions.visibilityOf(first_name_field));
        first_name_field.sendKeys(txt);
    }
    public void inputIntoLastNameField(String txt){
        wait.until(ExpectedConditions.visibilityOf(last_name_field));
        last_name_field.sendKeys(txt);
    }
    public void inputIntoZipCodeField(String txt){
        wait.until(ExpectedConditions.visibilityOf(postal_code_field));
        postal_code_field.sendKeys(txt);
    }

    public void clickOnContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

}
