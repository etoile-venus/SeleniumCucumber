package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends StepDefinition {
    WebDriverWait wait;
    public HomePage(){
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    public List<WebElement> addToCartButtons;

    @FindBy(css = "div[class='inventory_item_description']")
    public List<WebElement> inventoryItems;

    @FindBy(css = "div[class='inventory_item_name']")
    public List<WebElement> inventoryItemsNames;

    public void clickOnAnyItemsAddToCart(){
        wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtons.get(0)));
        addToCartButtons.get(0).click();
    }
    public void clickOnCartButton(){
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButton.click();
    }
}
