package pages.End2EndScenairos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.util.List;

public class ChekOutOverView extends PageBase {
    public ChekOutOverView(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.title")
    public WebElement assertCheckOutOverView ;


   @FindBy(css = "div.summary_info_label summary_total_label ")
   public WebElement summarytotallabel ;

    @FindBy(id = "finish")
    public  WebElement finishBtn;


    public  void finishOverView()
    {
        clickingAction(finishBtn);
    }


}
