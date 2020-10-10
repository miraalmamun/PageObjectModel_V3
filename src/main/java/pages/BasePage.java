package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {
	
	WebDriver driver;
	
	
	
	public void validateTitle(String expectedTitle)
	{
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
	
	
	public void wait(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
