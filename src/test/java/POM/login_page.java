package POM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import unilities.Driver;

public class login_page {

    public login_page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "user-name")
    public WebElement user_name_input;

    @FindBy(id = "password")
    public WebElement password_input;

    @FindBy(id = "login-button")
    public WebElement login_btn;

    public void logIn(String username, String password) { // it should be instance method, because we will call that method by that class object name!!!!!!!!!!!!!!!!!!!!!!!
        user_name_input.sendKeys(username);
        password_input.sendKeys(password);
        login_btn.click();
    }

}
