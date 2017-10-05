package a1qa.google.pages;

import org.openqa.selenium.By;

import a1qa.framework.pages.BasePage;

public class CommunityPage extends BasePage {
	
	private final static By COMMUNITY_LOCATOR = By.xpath("//div[contains(@class, 'community_activity_signin')]");
	
	public CommunityPage() {
		super(COMMUNITY_LOCATOR);
		log.info("Opened community page");
	}
}