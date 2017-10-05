package a1qa.google.pages;

import org.openqa.selenium.By;

import a1qa.framework.pages.BasePage;

import static a1qa.framework.utils.ConstantValue.*;

public class SteamDownloadPage extends BasePage {

	private static final By STEAM_DOWNLOAD = By.xpath("//div[contains(@class, 'install_ctn')][1]");
	private final By DOWNLOAD_FOR_WIN = By.xpath("//a[contains(@href, 'SteamSetup.exe')]");
	private final By DOWNLOAD_FOR_LINUX = By.xpath("//a[contains(@href, 'steam.deb')]");

	public SteamDownloadPage() {
		super(STEAM_DOWNLOAD);
		log.info("Opened Steam download page");
	}

	public SteamDownloadPage startDownloading() {
		log.info("Click download");
		switch (SYSTEM_OC) {
		case NAME_WINDOWS:
			clickElement(DOWNLOAD_FOR_WIN);
			break;
		case NAME_LINUX:
		case NAME_UNIX:
			clickElement(DOWNLOAD_FOR_LINUX);
			break;
		default:
			log.error("Error checking OC name");
			return null;
		}
		return this;
	}
}