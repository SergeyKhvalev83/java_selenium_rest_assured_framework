package stepDefinitions;

import POM.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import unilities.BrowserUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddProductToCart {
    HomePage homePage = new HomePage();
    String testItem = "Sauce Labs Backpack";
    String itemsCount = "1";

    @Given("the user is logged in and on Home page")
    public void the_user_is_logged_in_and_on_home_page() {

    }


    @When("the user clicks Add to cart for {string}")
    public void the_user_clicks_add_to_cart_for(String string) {
        homePage.clickAddToCartBtn(string);

    }


    @Then("the cart badge should display {string}")
    public void the_cart_badge_should_display(String string) {
       WebElement cartLable = BrowserUtils.waitForVisibility(By.xpath("//span[text()='1'])"), 2);
     String cartBadge = cartLable.getText();
        Assert.assertEquals("Badge matched", itemsCount, cartBadge);


    }
    @When("the user opens the shopping cart")
    public void the_user_opens_the_shopping_cart() {
        homePage.cartlink.click();


    }
    @Then("the product {string} should be displayed in the cart")
    public void the_product_should_be_displayed_in_the_cart(String string) {
        List<String> listOfItemsInCart = BrowserUtils.getElementsText(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertTrue(listOfItemsInCart.contains(testItem));


    }





}
