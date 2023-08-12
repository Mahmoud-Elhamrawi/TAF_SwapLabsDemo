package Tests.End2EndScenairo;

import Tests.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.End2EndScenairos.CartPage;
import pages.End2EndScenairos.CheckOutCompelet;
import pages.End2EndScenairos.ChekOutFillInfo;
import pages.End2EndScenairos.ChekOutOverView;
import pages.HomePage;
import pages.LoginPages.P01_loginPage;

public class TC02_CheckOutScenairoTest extends TestBase {
    P01_loginPage loginPage;
    SoftAssert softAssert ;

    @Test(priority = 1)
    public void validLogin(){
        loginPage = new P01_loginPage(driver);
        loginPage.fillLoginPage("standard_user" , "secret_sauce");
        softAssert = new SoftAssert();
        String actualUrl = "https://www.saucedemo.com/inventory.html";
        String expectUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectUrl);
        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(loginPage.homePageTitleAssert.getText().contains("Swag Labs"));
        System.out.println(loginPage.homePageTitleAssert.getText());

        softAssert.assertAll();
    }

    HomePage homePage ;
    @Test(priority = 2)
    public void addToCart(){
        homePage = new HomePage(driver);
        homePage.clickOnAddToCartProducts();
        homePage.clickOnShoppingCartLink();
        String actaulLinkCart ="https://www.saucedemo.com/cart.html";
        String expectLinkCart=driver.getCurrentUrl();
        softAssert.assertEquals(actaulLinkCart ,expectLinkCart);
        System.out.println(driver.getCurrentUrl());
    }


   CartPage cartPage ;
    @Test(priority = 3)
    public void CheckCart(){
        cartPage = new CartPage(driver);
        System.out.println(cartPage.assertCartTitle.getText());
        softAssert.assertTrue(cartPage.assertCartTitle.getText().contains("Your Cart"));
         cartPage.removeItem();
          cartPage.clickOncheckout();

    }

    ChekOutFillInfo chekOutFillInfo ;
    @Test(priority = 4)
    public void CheckOutInfo() throws InterruptedException {
        chekOutFillInfo = new ChekOutFillInfo(driver);
        softAssert.assertTrue(chekOutFillInfo.assertCheckOutTitle.getText().contains("Your Information"));
        chekOutFillInfo.fillInfoCheckOut("mahmoud" , "elhamrawi" ,"5050");
         softAssert.assertAll();
    }

    ChekOutOverView chekOutOverView ;

    @Test(priority = 5)
    public void CheckOutOverView(){
        chekOutOverView=new ChekOutOverView(driver);
        softAssert.assertTrue(chekOutOverView.assertCheckOutOverView.getText().contains("Overview"));
        chekOutOverView.finishOverView();
        softAssert.assertAll();

    }

    CheckOutCompelet checkOutCompelet ;
   @Test(priority = 6)
     public void CheckOutComplete() throws InterruptedException {
     checkOutCompelet = new CheckOutCompelet(driver);
     softAssert.assertEquals("Thank you for your order!",checkOutCompelet.assertCompleteHeader.getText());
     String actualUrlCheckOutCompelte ="https://www.saucedemo.com/checkout-complete.html";
     String expectCheckOutCompelte = driver.getCurrentUrl();
     softAssert.assertEquals(actualUrlCheckOutCompelte,expectCheckOutCompelte);
            System.out.println(driver.getCurrentUrl());
            Thread.sleep(2000);
         checkOutCompelet.backToProducts();
            String actualUrlHpme ="https://www.saucedemo.com/inventory.html";
            String expectUrlHome = driver.getCurrentUrl();
            softAssert.assertEquals(actualUrlHpme,expectUrlHome);
            System.out.println(driver.getCurrentUrl());
       softAssert.assertAll();
        }








}
