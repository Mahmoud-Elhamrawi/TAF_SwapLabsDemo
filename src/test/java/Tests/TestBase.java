package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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




}
