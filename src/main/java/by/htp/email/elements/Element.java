package by.htp.email.elements;

import org.openqa.selenium.WebElement;

public class Element {

	protected WebElement webElement;

	public Element(WebElement webElement) {
		this.webElement = webElement;
	}

	public WebElement getWebElement() {
		return webElement;
	}

	public void setWebElement(WebElement webElement) {
		this.webElement = webElement;
	}	
	
	
}
