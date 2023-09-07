package Tests.Login;

import Tests.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPages.P01_loginPage;
import pages.LoginPages.P02_LogOutPage;

public class TC01_LoginTest extends TestBase {

    P01_loginPage loginPage;
    SoftAssert softAssert ;

   @Test
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


    P02_LogOutPage logOutPage ;
    @Test(dependsOnMethods = {"validLogin"})
    public void LogOuT() throws InterruptedException {
        logOutPage = new P02_LogOutPage(driver);
        logOutPage.clickOnMenueBtn();
        Thread.sleep(2000);
        logOutPage.clickOnLogOutLink();
        String actualUrlLogOut ="https://www.saucedemo.com/";
        String expectUrlLogOut =driver.getCurrentUrl();
        softAssert.assertEquals(actualUrlLogOut,expectUrlLogOut);
        System.out.println(driver.getCurrentUrl());
        softAssert.assertAll();
    }






}
