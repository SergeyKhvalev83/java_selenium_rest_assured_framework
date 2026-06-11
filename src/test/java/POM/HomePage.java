package POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import unilities.Driver;
import unilities.BrowserUtils;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[class='app_logo']")
    public WebElement appLogo;

    @FindBy(id="burgerMenu")
    public WebElement burgerMenuBtn;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement sortDropDown;

    @FindBy(xpath = "div[class='inventory_item_name ']")
    public List<WebElement> listOfItems;

    @FindBy(css = "a[class='shopping_cart_link']")
    public WebElement cartlink;




    public void selectItemByTitle(String itemTitle) {
        for (WebElement eachElement : listOfItems) {
            if (eachElement.getText().equalsIgnoreCase(itemTitle)) {
                eachElement.click();
            }
        }
    }

    public WebElement clickAddToCartBtn(String itemTitle) {
    return  Driver.getDriver().findElement(
                By.xpath("//div[text()='" + itemTitle + "']/parent::a/parent::div/following-sibling::div/button")
        );
    }

}
