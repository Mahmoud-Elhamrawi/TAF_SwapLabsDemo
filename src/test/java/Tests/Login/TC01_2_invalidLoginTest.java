package Tests.Login;

import Tests.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPages.P01_loginPage;


public class TC01_2_invalidLoginTest extends TestBase {
    P01_loginPage loginPage;
    SoftAssert softAssert ;
   @Test
    public void invalidLogin(){
       loginPage = new P01_loginPage(driver);
       loginPage.fillLoginPage("locked_out_user" , "secret_sauce");
       softAssert = new SoftAssert();
       softAssert.assertTrue(loginPage.errorMsgLogin.getText().contains("Epic sadface: Username and password "));
       System.out.println(loginPage.errorMsgLogin.getText());

   }



}
