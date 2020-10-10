package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterPasswordPage extends BasePage{

	@FindBy(id = "password")
	WebElement loginPasswordField;
	@FindBy(id = "nextbtn")
	WebElement loginPasswordNextbtn;

	public EnterPasswordPage(WebDriver driver) {
          this.driver = driver;
	}

	public void submitUserName(String password) {
		
		wait(3);
		//driver.findElement(By.id("password")).sendKeys(password);
		
		loginPasswordField.sendKeys(password);
		
		wait(3);
		
		//driver.findElement(By.id("nextbtn")).click();
		
		loginPasswordNextbtn.click();
	}

}
