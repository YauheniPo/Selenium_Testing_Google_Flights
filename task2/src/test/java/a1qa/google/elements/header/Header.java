package a1qa.google.elements.header;

import org.openqa.selenium.By;

import a1qa.framework.elements.BaseElement;
import a1qa.framework.elements.Label;
import a1qa.google.pages.LoginPage;
import a1qa.google.pages.SteamDownloadPage;

public class Header extends BaseElement {
	
	private final static By LOCATOR_HEADER = By.xpath("//div[@id='global_actions']");
	private final By BTN_AUTHORIZE_USER = By.xpath("//span[contains(@id, 'account_pulldown')]");
	private final By BTN_LOGIN = By.xpath("//a[contains(@href, 'login')][contains(@class, 'global')]");
	public static final By INSTALL_STEAM = By.xpath("//div[contains(@class, 'installsteam')] //a");
	
	public Header(){
		super(LOCATOR_HEADER);
		log.info("Found the header");
	}
	
	protected Header(By locator){
		super(locator);
		log.info("Found the header");
	}
	
	public SteamDownloadPage clickSteamInstall() {
		log.info("Clicked Install Steam");
		clickElement(INSTALL_STEAM);
		return new SteamDownloadPage();
	}
	
	public LoginPage logging() {
		log.info("Clicked logging");
		clickElement(BTN_LOGIN);
		return new LoginPage();
	}
	
	public Header checkLoginValid(String login) {
		log.info("Checked validation login");
		String forCheckLogin = login.toLowerCase();
		new Label(BTN_AUTHORIZE_USER).checkLabel(forCheckLogin);
		return this;
	}
	
	public Header checkUserLogout(String login) {
		log.info("Checked logout user");
		new Label(BTN_LOGIN).checkNotLabel(login);
		return this;
	}
	
	public AccountMenu choiceAccountMenu() {
		log.info("Choice account menu");
		return new AccountMenu();
	}
	
	public LangMenu choiceLangMenu() {
		log.info("Choice language menu");
		return new LangMenu();
	}
}