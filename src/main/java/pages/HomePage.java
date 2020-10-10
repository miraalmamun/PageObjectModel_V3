package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	@FindBy(linkText = "Login")
	WebElement loginLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public EnterUserNamePage goToLoginPage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("Zoho - Cloud Software Suite and SaaS Applications for Businesses"));

		// driver.findElement(By.linkText("Login")).click();
        loginLink.click();
        
       // return new EnterUserNamePage(driver);
		return PageFactory.initElements(driver, EnterUserNamePage.class);
		
	}

	// Below methods should be in the BasePage class

	/*
	 * public void validateTitle(String expectedTitle) {
	 * Assert.assertEquals(driver.getTitle(), expectedTitle); }
	 */

}
