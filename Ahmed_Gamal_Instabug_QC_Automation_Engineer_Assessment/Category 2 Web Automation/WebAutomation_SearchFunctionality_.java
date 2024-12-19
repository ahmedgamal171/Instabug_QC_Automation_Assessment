import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
private WebDriver driver;

@Before
public void setUp(){
    //intialize webdriver
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    driver = new ChromeDriver();
}

@Test
public void TestSearchFunctionality(){
    driver.get("https://www.example-ecommerce-website.com");
    WebElement elementsearchbox=driver.findElement(By.id("search-bar"));
    searchbox.sendKeys("Laptop");
    searchbox.sendKeys(Keys.RETURN) ;
    
    Thread.sleep(3000) ;//wait until prodcuts displayed
    
    List<WebElement> results=driver.findElements(By.cssSelector(".product-listing")) ;//Assuming that the products will have css selector .product-listing
    
    Assert.assertTrue("No search results displayed.", results.size() > 0); //Returns true if results contains at least 1 item
    
}

@After
public void tearDown() {
    if (driver != null) {
        driver.quit();  
    }
}

}