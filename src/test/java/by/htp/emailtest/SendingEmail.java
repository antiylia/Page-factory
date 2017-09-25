package by.htp.emailtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.htp.email.pages.InBoxPage;
import by.htp.email.pages.MainPage;
import by.htp.email.pages.WriteEmailPage;

public class SendingEmail {
 
	private WriteEmailPage writeEmailPage;
	private MainPage mainPage;
	private WebDriver driver;
	private InBoxPage inBoxPage;
	
	@FindBy(xpath = "//div[@class='message-sent__title']")
	WebElement responce;
	
	
	private String letter = "-----";
	private String theme = "Антипирович Юлия ДЗ: Page Object Pattern";
	//private String recipient = "sviatlana.zakharenka@gmail.com";
	private String recipient = "tathtp@mail.ru";
	

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		mainPage = new MainPage(driver);
		mainPage.open();
		writeEmailPage = mainPage.logIn("tathtp", "Klopik123").startWrittingEmail();
		PageFactory.initElements(driver, this);
	}
		
	@Test
	public void sendsEmail() {
		writeEmailPage.writeEmail(recipient, theme, letter);		
		Assert.assertNotNull(responce);	
	}			
	
	@AfterClass
    public void logoutExit() {	
		inBoxPage = writeEmailPage.comeTolistNewEmail();
		inBoxPage.logOut();		
    }	
	
}
