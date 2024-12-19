import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class LoginTest {

    private AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");     //IOS for Iphone
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("deviceName", "Android Emulator");//Iphone Simulator for Iphone
        capabilities.setCapability("app", "app/path/app.apk");  
        capabilities.setCapability("automationName", "UiAutomator2"); //XCUITest for iphone
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), capabilities); //Appium Server
    }

    @Test
    public void testValidLogin() {
        MobileElement usernameField = driver.findElement(By.xpath("//android.widget.EditText[not(@id) and not(@placeholder)]"));
        usernameField.sendKeys("testuser");

        MobileElement passwordField = driver.findElement(By.xpath("//android.widget.EditText[@placeholder='Enter your password']"));
        passwordField.sendKeys("password123");

        MobileElement loginButton = driver.findElement(By.xpath("//android.widget.Button[@text='Login']"));
        loginButton.click();

        Thread.sleep(5000);
        
        MobileElement homeScreenElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Home']"));
        Assert.assertTrue(homeScreenElement.isDisplayed(), "Home screen is not displayed after successful login.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the app and stop the driver session
        }
    }
}
