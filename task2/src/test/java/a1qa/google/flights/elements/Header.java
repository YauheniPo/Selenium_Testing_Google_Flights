package a1qa.google.flights.elements;

import static org.testng.Assert.*;

import org.openqa.selenium.By;

import a1qa.framework.elements.BaseElement;
import a1qa.framework.elements.Button;
import a1qa.framework.elements.TextBox;
import a1qa.framework.utils.Numbers;
import a1qa.google.flights.pages.LoginPage;

import static a1qa.framework.utils.ConstantValue.*;

public class Header extends BaseElement{
	
	private final static By HEADER = By.xpath("//div[@id='gb']");
	private final By HEADER_SEARCH = By.xpath("//input[contains(@id, 'qfq')]");
	private final By HEADER_SIGN_IN = By.xpath("//a[@id='gb_70']");
	private final By HEADER_ACCOUNT = By.xpath("//a[contains(@title, 'ccount')]");
	private final By HEADER_SIGN_OUT = By.xpath("//a[contains(@href, 'ogout')]");

	public Header() {
		super(HEADER);
		log.info("Found the header");
	}

	public Header setSearch(String text) {
		log.info("Input to the search engine");
		new TextBox(HEADER_SEARCH).inputData(text);
		return this;
	}
	
	public String getSearchingText() {
		log.info("Get text from search engine");
		return new TextBox(HEADER_SEARCH).getText();
	}
	
	public LoginPage logging() {
		log.info("Click logging");
		new Button(HEADER_SIGN_IN).clickBnt();
		return new LoginPage();
	}
	
	public LoginPage logout() {
		log.info("Click log out");
		new Button(HEADER_ACCOUNT).clickBnt();
		new Button(HEADER_SIGN_OUT).clickBnt();
		return new LoginPage();
	}
	
	public Header checkAuthorization(String login) {
		log.info("Checking user authorization");
		String strAtrib = getAttribute(HEADER_ACCOUNT, INPUT_ATRIBUTE_TITLE);
		assertTrue(strAtrib.indexOf(login) >= Numbers.ZERO.getNumber(), "Error authorization");
		log.info("User is authorization");
		return this;
	}
	
	public Header checkUserLogout() {
		log.info("Checking user logout");
		assertFalse(isNotNull(HEADER_ACCOUNT), "Error log out");
		log.info("User is log out");
		return this;
	}
}