package Steps;

import Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinition {
    private static final Log log = LogFactory.getLog(StepDefinition.class);
    public static WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmPurchasePage confirmPurchasePage;
    CheckoutCompletePage checkoutCompletePage;

    @Before
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        confirmPurchasePage = new ConfirmPurchasePage();
        checkoutCompletePage = new CheckoutCompletePage();
    }

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("user input “standard_user”  in username field")
    public void userInputsValidUsername(){
        loginPage.inputUsername("standard_user");
    }
    @When("user adds any item to cart")  //nzm kako da izvedem to za bilo koju stvar
    public void userCanAddAnyItemToCart(){
        homePage.clickOnAnyItemsAddToCart();
    }
    @When("user clicks on checkout button")
    public void clickOnCheckoutButton(){
        cartPage.clickOnCheckoutButton();
    }
    @When("user inputs “John” in first name field")
    public void userInputFirstName(){
        checkoutPage.inputIntoFirstNameField("John");
    }
    @When("user clicks on finish button")
    public void userClicksOnFinishButton(){
        confirmPurchasePage.clickOnFinishButton();
    }
    @When("user clicks on back home button")
    public void userClicksOnBackHomeButton(){
        checkoutCompletePage.clickOnBackHomeButton();
    }
    @And("user input “secret_sauce” in password field")
    public void userInputsValidPassword(){
        loginPage.inputPassword("secret_sauce");
    }
    @And("user click on Login button")
    public void userClicksOnLoginButton(){
        loginPage.clickOnLoginButton();
    }
    @And("redirected to Home page")
    public void redirectedToHomepage(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertTrue(homePage.cartButton.isDisplayed());
    }
    @And("user goes to cart")
    public void goToCartPage(){
        homePage.cartButton.click();
    }

    @And("user inputs “Smith” in lastname field")
    public void inputIntoLastNameField()
    {
        checkoutPage.inputIntoLastNameField("Smith");
    }
    @And("user inputs “10001” in zipcode field")
    public void inputIntoZipCodeField()
    {
        checkoutPage.inputIntoZipCodeField("10001");
    }
    @And("user clicks on continue button")
    public void clickOnContinueButton(){
        checkoutPage.clickOnContinueButton();
    }
    @Then("user is successfully logged in")
    public void userIsLoggedIn(){
        Assert.assertTrue(homePage.cartButton.isDisplayed());
    }
    @Then("item is in cart")
    public void itemIsInCart(){
        boolean isInCart = false;
        for (WebElement item: cartPage.itemsInCartNames)
        {
            if(item.getText().equals(homePage.inventoryItemsNames.get(0).getText())){
                isInCart = true;
            }
        }
        Assert.assertTrue(isInCart);
    }
    @Then("user is on Checkout page")
    public void userIsOnCheckoutPage(){
        Assert.assertEquals(checkoutPage.title.getText().trim(),"Checkout: Your Information");
    }
    @Then("user is on Confirm purchase page")
    public void userIsOnConfirmPurchasePage(){
        Assert.assertEquals(confirmPurchasePage.titleElement.getText().trim(), "Checkout: Overview");
    }
    @Then("purchase is confirmed")
    public void purchaseIsConfirmed(){
        Assert.assertEquals(checkoutCompletePage.titleElement.getText().trim(), "Thank you for your order!");
    }
    @Then("user is redirected to Home page")
    public void userIsRedirectedToHomePage(){
        Assert.assertTrue(homePage.cartButton.isDisplayed());
    }
    @Given("user is logged in")
    public void userIsLoggedInGiven() {
        driver.get("https://www.saucedemo.com");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.cartButton.isDisplayed());
    }
    @Given("user is on checkout page with added item")
    public void userIsOnCheckoutPageWithAddedItem(){
        driver.get("https://www.saucedemo.com");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        homePage.clickOnAnyItemsAddToCart();
        homePage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
    }
    @Given("user is on Confirm purchase Page")
    public void UserIsOnConfirmPurchasePage(){
        driver.get("https://www.saucedemo.com");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        homePage.clickOnAnyItemsAddToCart();
        homePage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputIntoFirstNameField("Danica");
        checkoutPage.inputIntoLastNameField("Bijeljanin");
        checkoutPage.inputIntoZipCodeField("10001");
        checkoutPage.clickOnContinueButton();
    }
    @Given("user has purchased an item")
    public void userHasPurchasedAnItem(){
        driver.get("https://www.saucedemo.com");
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        homePage.clickOnAnyItemsAddToCart();
        homePage.clickOnCartButton();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputIntoFirstNameField("Danica");
        checkoutPage.inputIntoLastNameField("Bijeljanin");
        checkoutPage.inputIntoZipCodeField("10001");
        checkoutPage.clickOnContinueButton();
        confirmPurchasePage.clickOnFinishButton();
    }

}
