package pages.End2EndScenairos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class CartPage extends PageBase {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="span.title")
    public WebElement assertCartTitle ;

   @FindBy(id = "remove-sauce-labs-bike-light")
    public  WebElement removelabsbikelightProduct;


   @FindBy(id = "checkout")
   public  WebElement checkoutBtn ;



   public void removeItem(){
       clickingAction(removelabsbikelightProduct);
   }
 public void clickOncheckout()
 {
     clickingAction(checkoutBtn);
 }


}
