package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage extends BasePage {

	public LaunchPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage navigateToHomePage() {

		driver.get("https://www.zoho.com/");
        
		
		//return new HomePage(driver)
		return PageFactory.initElements(driver, HomePage.class);
		//Create object of HomePage
		//pass the driver
		//initialize object of HomePage(@FindBy initialize the locators/Elements)

	}

}
