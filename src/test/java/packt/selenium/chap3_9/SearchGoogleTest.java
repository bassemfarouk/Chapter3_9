package packt.selenium.chap3_9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import packt.selenium.chap3_9.pageobjects.GoogleHomePage;
import packt.selenium.chap3_9.pageobjects.GoogleSearchPage;


public class SearchGoogleTest {
	
	private WebDriver driver;
	private GoogleHomePage googleHomePage;
	private GoogleSearchPage googleSearchPage;

	
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","D:\\Selenium Jars And Eclipse\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	
	@Test
	public void testGoogleSearch() throws InterruptedException{
		googleHomePage = new GoogleHomePage(driver);
		googleSearchPage = googleHomePage.goToSearchPage();
		googleSearchPage.numberOfResults();

	}
				
		
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
