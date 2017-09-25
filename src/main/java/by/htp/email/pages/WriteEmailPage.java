package by.htp.email.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.htp.email.elements.Button;
import by.htp.email.elements.Input;

public class WriteEmailPage extends Page {

	@FindBy(xpath = "//textarea[@class = 'js-input compose__labels__input']")
	private Input recepient;

	@FindBy(xpath = "//input[@class = 'b-input']")
	private Input theme;

	@FindBy(xpath = "//iframe[starts-with(@id,'toolkit')]")
	private WebElement iframe;

	@FindBy(xpath = "//span[@class = 'b-toolbar__btn__text']")
	private Button sendEmail;

	@FindBy(xpath = "//span[@class='b-nav__item__text']")
	private Button listNewEmail;
	
	@FindBy(id = "tinymce")
	private Input textEmail;

	public WriteEmailPage(WebDriver driver) {
		super(driver);
	}

	public void writeEmail(String u_recipient, String u_theme, String u_letter) {
		waitSpecifiedElement(recepient);
		recepient.fillInputWithClick(u_recipient);
		theme.fillInputWithClick(u_theme);
		fillEmailContent(u_letter);
		sendEmail.click();
	}

	public InBoxPage comeTolistNewEmail() {
		listNewEmail.click();
		return new InBoxPage(driver);
	}

	private void fillEmailContent(String content) {
		
		WebElement iframe1 = driver.findElement(By.xpath("//iframe[starts-with(@id,'toolkit')]")); 
		driver.switchTo().frame(iframe1);
	//	driver.switchTo().frame(iframe);
		textEmail.focusInput();
		textEmail.fillInputWithClick(content);
		driver.switchTo().defaultContent();
	}

}
