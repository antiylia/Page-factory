package by.htp.email.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import by.htp.email.elements.Button;

public class InBoxPage extends Page {

	@FindBy(xpath = "//a[@id='PH_logoutLink']")
	private Button logOut;

	@FindBy(xpath = "//div[@id='LEGO']//span")
	private Button writeEmail;

	public InBoxPage(WebDriver driver) {
		super(driver);
	}

	public WriteEmailPage startWrittingEmail() {
		driver.navigate().refresh();
		waitSpecifiedElement(writeEmail);
		writeEmail.click();
		return new WriteEmailPage(driver);
	}

	public MainPage logOut() {
		driver.navigate().refresh();
		logOut.click();
		return new MainPage(driver);
	}

}
