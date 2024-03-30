package Com.testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddAndRemoveFromCart {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;

    public static void main(String[] args) throws IOException {
        fr = new FileReader("C:\\Users\\sursingh21\\eclipse-workspace\\amazonTest\\src\\test\\resources\\configfiles\\config.properties");
        prop.load(fr);

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {							//check the browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(prop.getProperty("testurl"));
        Test();
    }

    @SuppressWarnings("deprecation")
	private static void Test() {
        driver.findElement(By.id("nav-link-accountList")).click();					//click on the login button
        driver.findElement(By.id("ap_email")).sendKeys("username");					//enter the username
        driver.findElement(By.id("continue")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("ap_password")).sendKeys("password");				// enter the password
        driver.findElement(By.id("signInSubmit")).click();							//click on login button
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);       

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));			//search the product
        search.sendKeys("iPhone 15");
        driver.findElement(By.id("nav-search-submit-button")).click();									// click on the search
        driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15 (128 GB) - Blue')]")).click();			// click on the product

        Set<String> handles = driver.getWindowHandles();						//getting window handles foe switching the window
		ArrayList ar = new ArrayList(handles);
        driver.switchTo().window((String)ar.get(1));								//switching to the product window
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//*[@id=\"atc-declarative\"])[2]")).click();     //adding product into cart
        driver.findElement(By.cssSelector("#attach-sidesheet-view-cart-button > span > input")).click(); //adding the recommended product
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.name("submit.addToCart")).click();										//adding to the cart
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("nav-cart")).click();													//navigating to the cart
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();							//removing extra products
        driver.quit();
    }
}
