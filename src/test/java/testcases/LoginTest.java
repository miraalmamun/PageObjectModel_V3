package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.EnterPasswordPage;
import pages.EnterUserNamePage;
import pages.HomePage;
import pages.LaunchPage;

public class LoginTest {

	// Problem in this way to build a framework
	// Passing of driver object in the every methods
	// Other Object also Example: Extends Reports and log
	//So far I am creating driver object in @Test level and passing it to the page classes.
	//I am passing driver through every method. This is not a good approach. Because I am ending up 
	//writing extra codes
	//Second solution Look at V2. This is V1.
	//------------------------------Below about Version Two-------------------------
	//In second solution why don't you pass it through constructor
	//Every Page class used to have it's own driver object and constructor. I will initialize the driver
	//through constructor
	//At the time of initialize in A Page I will send A driver object in it, So driver of the page initialize
	//So driver don't need to pass every method.
	//One page class creates the object of Another Page class
	//One page class initialize Another page class-->When I initialize I will pass driver again
	//One page class methods will give you another page class. This is the Golden principle of
	//Page Object Model
	//-------------------------------------3rd problem in version 3---------------------------------------------
	//How to manage passing data from one Test case to multiples Pages. There is other problem as well, Let's say
	//you have a method in HomePage to validate the title. So every Page has validate function. If there is 500
	//Pages then I have to copy and past this validate method 500 times. So code will be repeat. Which is again not a 
	//good. The solution is simple. Create a Base Page and then  declare common methods of all pages in the Base Page
	//class. All the Page class extends the BasePage class. Declare the driver in the BasePage class
	//There are some common validation applicable for any web application(validateTitle, validateElementPresence
	//,validateTitle, screenshots, log). There will be 1000's methods in BasePage class. So BasePage class size a problem
	//PageFactory design Pattern--> Help us implements Page Object Model in a better way.
	//PageFactory design Pattern--> passing the driver, create Object and initialize of elements/Object(locator)
	
	
	/*
	
	What is Page Factory in Selenium?
			Page Factory in Selenium is an inbuilt Page Object Model concept for Selenium WebDriver 
			but it is very optimized. It is used for initialization of Page objects or to instantiate 
			the Page object itself. It is also used to initialize Page class elements without 
			using "FindElement/s."

			Here as well, we follow the concept of separation of Page Object Repository and Test Methods. 
			Additionally, with the help of PageFactory class, we use annotations @FindBy to find WebElement.
			We use initElements method to initialize web elements
	
	
	*/
	
	
	
	//LaunchPage lp = new LaunchPage(driver); I am passing the driver here. PageFactory design patterns
	// says don't create the object like this way. In PageFactory we do 
	// PageFactory.initElements(driver, the Page which would be initialize);--->This is PageFactory way
	//PageFactory.initElements(driver, LaunchPage.class);--->It will create of LaunchPage, passing driver
	//in it and initialize elements in it. And it will return object of LaunchPage
	// LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
	
	/*
	public HomePage navigateToHomePage() {

		driver.get("https://www.zoho.com/");
		System.out.println(driver.getTitle());

		return new HomePage(driver);

	}
	
	   Above method will be in PageFactory Design Pattern below
	   
	   public HomePage navigateToHomePage() {

		driver.get("https://www.zoho.com/");
		System.out.println(driver.getTitle());

		return PageFactory.initElements(driver, HomePage.class);

	}
	
	
	*/
	
	
	
	
	
	
	

	@Test
	public void loginTest() {

		// ExtentReports rep = new ExtentReports();
		// ExtentTest test = rep.createTest("loginTest".toUpperCase());
		// test.log(Status.INFO, "initializing browser");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		//LaunchPage lp = new LaunchPage(driver);
		LaunchPage lp = PageFactory.initElements(driver, LaunchPage.class);
		
		HomePage hp = lp.navigateToHomePage();
		hp.validateTitle("Zoho - Cloud Software Suite and SaaS Applications for Businesses");
		EnterUserNamePage userNamePage = hp.goToLoginPage();
		EnterPasswordPage passwordPage = userNamePage.submitUserName("miraalmamun@gmail.com");
		passwordPage.submitUserName("Mimo949658");
		driver.quit();

	}

}
