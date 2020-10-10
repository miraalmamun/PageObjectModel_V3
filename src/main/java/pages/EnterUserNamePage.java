package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterUserNamePage extends BasePage{
   
	
	@FindBy(id = "login_id")
	WebElement loginUserNameField;
	@FindBy(id = "nextbtn")
	WebElement loginUserNameFieldNextbtn;
	

	public EnterUserNamePage(WebDriver driver) {
		this.driver = driver;
	}

	public EnterPasswordPage submitUserName(String userName) {
		
        
		//driver.findElement(By.id("login_id")).sendKeys(userName);
		loginUserNameField.sendKeys(userName);
		
		
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("nextbtn")));
		

		//driver.findElement(By.id("nextbtn")).click();
		loginUserNameFieldNextbtn.click();
		
        //return new EnterPasswordPage(driver);
		return PageFactory.initElements(driver, EnterPasswordPage.class);
	}

}
