package pages.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class P01_loginPage extends PageBase {
    public P01_loginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    public WebElement userNameLogin;

    @FindBy(id = "password")
    public WebElement passwordLogin;

    @FindBy(id = "login-button")
    public WebElement loginBtn ;

    @FindBy(css = "div.app_logo")
    public WebElement homePageTitleAssert;


    @FindBy(css = "button.error-button")
    public  WebElement errorMsgLogin ;




    public void fillLoginPage(String userName , String userPassword)
    {
        userNameLogin.sendKeys(userName);
        passwordLogin.sendKeys(userPassword);
        clickingAction(loginBtn);
    }





}
