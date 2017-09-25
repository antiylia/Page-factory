package by.htp.emailtest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.email.pages.InBoxPage;
import by.htp.email.pages.MainPage;

public class LoginInTest {
 
	private MainPage mainPage;
	private WebDriver driver;
	private InBoxPage inBoxPage;
	
	@FindBy(xpath = "//table[@class='x-ph__auth']/descendant::a[@id='PH_logoutLink']")
	WebElement testExit;
		

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		mainPage = new MainPage(driver);
		PageFactory.initElements(driver, this);
	}

	@Test
	public void logOutIsFound() {

		mainPage.open();
		inBoxPage = mainPage.logIn("tathtp", "Klopik123");
		driver.navigate().refresh();
					
		assertNotNull(inBoxPage);
		assertEquals("выход", testExit.getText());
	}

	@AfterClass
	public void logout() {
		if (inBoxPage !=null) {
		   inBoxPage.logOut();		
		}	
	}
	
}
