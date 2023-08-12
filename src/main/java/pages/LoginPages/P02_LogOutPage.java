package pages.LoginPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class P02_LogOutPage extends PageBase {
    public P02_LogOutPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "react-burger-menu-btn")
    public WebElement menueBarBtn ;
    @FindBy(id = "logout_sidebar_link")
    public  WebElement logOutLink ;


    public void clickOnMenueBtn(){
        clickingAction(menueBarBtn);
    }

    public void clickOnLogOutLink(){
        clickingAction(logOutLink);
    }


}
