package by.htp.email.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import by.htp.email.elements.Button;
import by.htp.email.elements.Element;
import by.htp.email.elements.Input;


public class MainPage extends Page {

	private static final String URL = "https://mail.ru";
	
	@FindBy(xpath = "//form[@class='mailbox__auth__layout clearfix']/descendant::input")
	@CacheLookup
	private Element logo;
	
	@FindBy(id = "mailbox__auth__button")
	@CacheLookup
	private Button buttonSubmit;

	@FindBy(id = "mailbox__login")
	private Input login;
	
	@FindBy(id = "mailbox__password")
	private Input password;

	public MainPage(WebDriver driver) {
		super(driver);		
	}

	public void open() {
		super.open(URL);
	}

	public InBoxPage logIn(String u_login, String u_password) {
		waitSpecifiedElement(logo);
		login.fillInput(u_login);   // "tathtp" 
		password.fillInput(u_password);  // "Klopik123"
		buttonSubmit.click();
		return new InBoxPage(driver);
	}

}
