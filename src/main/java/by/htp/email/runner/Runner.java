package by.htp.email.runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import by.htp.email.pages.InBoxPage;
import by.htp.email.pages.MainPage;
import by.htp.email.pages.WriteEmailPage;


public class Runner {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "D:\\geckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		MainPage mainPage = new MainPage(driver);
		mainPage.open();

		InBoxPage inBoxPage = mainPage.logIn("tathtp", "Klopik123");
		WriteEmailPage writeEmailPage = inBoxPage.startWrittingEmail();

		String content = "HomeTask_Antipirovich_Y";

		writeEmailPage.writeEmail("tathtp@mail.ru", "СПАМ_Антипирович Юлия_ДЗ_AutoEmail", content);

		inBoxPage = writeEmailPage.comeTolistNewEmail();
		mainPage = inBoxPage.logOut();
	}

}
