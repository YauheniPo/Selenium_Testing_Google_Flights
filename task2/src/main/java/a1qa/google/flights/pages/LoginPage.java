package a1qa.google.flights.pages;

import org.openqa.selenium.By;

import a1qa.framework.entity.elements.Button;
import a1qa.framework.entity.elements.TextBox;
import a1qa.framework.entity.pages.BasePage;

public class LoginPage extends BasePage {
	
	private static final By LOGIN_PAGE = By.xpath("//div[@id='initialView']");
	private final By LOGIN_PAGE_INPUT_LOGIN = By.xpath("//input[@id='identifierId']");
	private final By LOGIN_PAGE_INPUT_PASSWORD = By.xpath("//input[@type='password']");
	private final By LOGIN_PAGE_SUBMIT = By.xpath("//div[contains(@id, 'Next')]");

	public LoginPage() {
		super(LOGIN_PAGE);
		log.info("Opened login page");
	}

	public LoginPage typeUsername(String name) {
		log.info("Inputted user login");
		new TextBox(LOGIN_PAGE_INPUT_LOGIN).inputData(name);
		return this;
	}
	
	public LoginPage typePassword(String pass) {
		log.info("Inputted user password");
		isElementDisplayed(LOGIN_PAGE_INPUT_PASSWORD);
		new TextBox(LOGIN_PAGE_INPUT_PASSWORD).inputData(pass);
		return this;
	}
	
	public void submit() {
		log.info("Clicked - Log in");
		new Button(LOGIN_PAGE_SUBMIT).clickBnt();
	}
	
	public void loginAs(String login, String pass) {
		typeUsername(login);
		submit();
		typePassword(pass);
		submit();
	}
}