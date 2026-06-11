package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import unilities.Driver;

import java.util.List;

public class cartPage {

    public cartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='cart_desc_label']")
    public WebElement descriptionLable;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<WebElement> listOfItemsListOfCartItems;




}
