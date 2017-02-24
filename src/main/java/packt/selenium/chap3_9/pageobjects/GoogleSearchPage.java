package packt.selenium.chap3_9.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

	private WebDriver driver;
	
	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
        if (!driver.getTitle().equals("Mastering Selenium Testing Tools - Google Search")){
            throw new WrongPageException("Incorrect page for GoogleSearchPage");
        }
	}
	
	public void numberOfResults(){
		String numberOfResults = driver.findElement(By.id("resultStats")).getText();
		System.out.println(numberOfResults);
	}
	

}
