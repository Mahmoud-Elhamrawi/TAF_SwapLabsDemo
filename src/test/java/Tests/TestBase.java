package Tests;

import Utilies.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public   static WebDriver driver;


    @BeforeClass
    @Parameters({"Browser"})
    public void OpenBroswer(@Optional("chrome")  String browserName)
        {
            if (browserName.equalsIgnoreCase("chrome"))
            {
                driver = new ChromeDriver();
            }
            else if (browserName.equalsIgnoreCase("firefox"))
            {
                driver = new FirefoxDriver();
            }
            else if (browserName.equalsIgnoreCase("IE"))
            {
                driver= new EdgeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.navigate().to("https://www.saucedemo.com/");

        }




   @AfterClass
    public void QuitBroswer() throws InterruptedException {

    Thread.sleep(3000);
    driver.quit();
    }

    @AfterMethod()
    public void screenShotFailure(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            System.out.println("fail...");
            System.out.println("taking screenshot.....");
            Helper.captureScreen(driver,result.getName());
        }

    }



}
