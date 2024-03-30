package Com.testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addToCartAndCheckOut {
	
	 public static WebDriver driver;
	    public static Properties prop = new Properties();
	    public static FileReader fr;

	    public static void main(String[] args) throws IOException {
	        fr = new FileReader("C:\\Users\\sursingh21\\eclipse-workspace\\amazonTest\\src\\test\\resources\\configfiles\\config.properties");
	        prop.load(fr);

	        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }

	        driver.get(prop.getProperty("testurl"));
	        testcase();
	    }

	@SuppressWarnings("deprecation")
	public static void testcase() {

		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("ssurendra039@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Sure@1123");
		driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("iPhone 15");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 15 (128 GB) - Blue')]")).click();
		Set<String> handles = driver.getWindowHandles();
		ArrayList ar = new ArrayList(handles);
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));
		//System.out.println(ar.get(2));
		
		driver.switchTo().window((String)ar.get(1));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[@id=\"atc-declarative\"])[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"add-new-address-popover-link\"]")).click();
		
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']")).sendKeys("Surendra Singh");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']")).sendKeys("8267897416");
		driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']")).sendKeys("202001");
		WebElement address= driver.findElement(By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']"));
		address.sendKeys("Natraj Campus");
		address.sendKeys(Keys.ARROW_DOWN);
		address.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[@id='address-ui-widgets-form-submit-button']")).click();
		
		
		driver.quit();

	}

}
