package by.htp.email.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import by.htp.email.decorator.UserDecorator;
import by.htp.email.elements.Element;

public abstract class Page {

	protected final WebDriver driver;

	protected Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new UserDecorator(driver), this);
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	protected void open(String url) {
		getDriver().get(url);
	}
	
	protected WebDriver waitSpecifiedElement (Element element) {		
		Wait<WebDriver> wait = new WebDriverWait(driver, 20L, 1000L).withMessage("Element was not found");
	    wait.until(ExpectedConditions.visibilityOf(element.getWebElement()));
		return driver;
	}

}
