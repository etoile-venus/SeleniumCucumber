package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends StepDefinition {
    WebDriverWait wait;
    public CartPage(){

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(css = "div[class='cart_item']")
    public List<WebElement> itemsInCart;

    @FindBy(className = "inventory_item_name")
    public List<WebElement> itemsInCartNames;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public void clickOnCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        checkoutButton.click();
    }
}
