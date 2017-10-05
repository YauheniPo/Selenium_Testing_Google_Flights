package a1qa.google.pages;

import org.openqa.selenium.By;

import a1qa.framework.elements.TextBox;
import a1qa.framework.pages.BasePage;

public class LoginPage extends BasePage {
	
	private final static By BUTTON_SIGN_IN_LOCATOR = By.xpath("//button[@type='submit']");
	private final By USERNAME_FIELD_LOCATOR = By.cssSelector("#input_username");
	private final By PASSWORD_FIELD_LOCATOR = By.cssSelector("#input_password");
	
	public LoginPage() {
		super(BUTTON_SIGN_IN_LOCATOR);
		log.info("Opened login page");
	}
	
	public LoginPage typeUsername(String name) {
		log.info("Inputted user login");
		new TextBox(USERNAME_FIELD_LOCATOR).inputData(name);
		return this;
	}
	
	public LoginPage typePassword(String pass) {
		log.info("Inputted user password");
		new TextBox(PASSWORD_FIELD_LOCATOR).inputData(pass);
		return this;
	}
	
	public LoginPage submit(By locator) {
		log.info("Clicked - Log in");
		clickElement(locator);
		return this;
	}
	
	public void loginAs(String login, String pass) {
		typeUsername(login);
		typePassword(pass);
		submit(BUTTON_SIGN_IN_LOCATOR);
	}
}