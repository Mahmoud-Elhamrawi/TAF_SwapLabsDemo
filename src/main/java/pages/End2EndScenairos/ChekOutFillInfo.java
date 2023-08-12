package pages.End2EndScenairos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class ChekOutFillInfo extends PageBase {
    public ChekOutFillInfo(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "span.title")
    public WebElement assertCheckOutTitle;

     @FindBy(id = "first-name")
    public  WebElement firstNameInput;

    @FindBy(id = "last-name")
    public  WebElement lasttNameInput;

    @FindBy(id = "postal-code")
    public  WebElement postalCodeInput;


    @FindBy(id = "continue")
    public  WebElement continueBtn ;


    public void fillInfoCheckOut(String Fanme , String Lname , String Pocode) throws InterruptedException {
        firstNameInput.sendKeys(Fanme);
        Thread.sleep(1000);
        lasttNameInput.sendKeys(Lname);
        Thread.sleep(1000);
        postalCodeInput.sendKeys(Pocode);
        Thread.sleep(1000);
        clickingAction(continueBtn);

    }




}
