package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addsaucelabsbikelightBtn;

     @FindBy(id = "add-to-cart-sauce-labs-onesie")
     public  WebElement addsaucelabsonesieBtn;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public  WebElement addsaucefleecejacketBtn;
   @FindBy(css = "a.shopping_cart_link")
   public  WebElement shoppingCartLink;



     public void clickOnAddToCartProducts()
     {
         clickingAction(addsaucelabsbikelightBtn);
         clickingAction(addsaucelabsonesieBtn);
         clickingAction(addsaucefleecejacketBtn);
     }
     public void clickOnShoppingCartLink(){
         clickingAction(shoppingCartLink);
     }


}
