package pages.End2EndScenairos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class CheckOutCompelet extends PageBase {
    public CheckOutCompelet(WebDriver driver) {
        super(driver);
    }

   @FindBy(css = "h2.complete-header")
    public WebElement assertCompleteHeader;

    @FindBy(id = "back-to-products")
    public WebElement backtoproductsBtn;

  public void backToProducts(){
      clickingAction(backtoproductsBtn);
  }



}
