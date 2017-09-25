package by.htp.email.elements;

import org.openqa.selenium.WebElement;

public class Input extends Element {

	public Input(WebElement webElement) {
		super(webElement);
	}

	public void fillInput(String text) {
		webElement.sendKeys(text);
	}

	public void fillInputWithClick(String text) {
		webElement.sendKeys(text);
		webElement.click();
	}

	public void focusInput() {
		webElement.click();
	}

}
