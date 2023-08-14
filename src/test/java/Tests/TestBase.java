package Tests;

import Utilies.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
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
            else if (browserName.equalsIgnoreCase("IE")) {
                driver = new EdgeDriver();
            }
//            else if (browserName.equalsIgnoreCase("headless")) {
//
//                DesiredCapabilities caps = new DesiredCapabilities();
//                caps.setJavascriptEnabled(true);
//                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,System.getProperty("user.dir")+"/drivers/phantomjs.exe");
//                String [] phantomJsArgs = {"--web-security=no", "--ignore-ssl-errors=yes"};
//                caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
//                driver = new PhantomJSDriver(caps);
//
//            }
            else if (browserName.equalsIgnoreCase("headless-chrome")) {
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless");
                option.addArguments("--window-size=1920,1080");
                driver = new ChromeDriver(option);

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
