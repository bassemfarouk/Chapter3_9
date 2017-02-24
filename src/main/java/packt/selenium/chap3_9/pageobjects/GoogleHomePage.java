package packt.selenium.chap3_9.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage {
	
	private WebDriver driver;
	private String baseURL = "http://www.google.com";

	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(baseURL + "/");
        if (!driver.getTitle().equals("Google")) {
            throw new WrongPageException("Incorrect page for Google Homepage");
        }
	}
	
	public GoogleSearchPage goToSearchPage(){
		
        driver.findElement(By.id("lst-ib")).sendKeys("Mastering Selenium Testing Tools");
        driver.findElement(By.name("btnG")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));		
		return new GoogleSearchPage(driver);
	}
	
}
