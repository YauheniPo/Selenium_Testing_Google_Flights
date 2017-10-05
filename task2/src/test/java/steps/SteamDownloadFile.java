package steps;

import a1qa.framework.test.BaseTest;
import a1qa.framework.utils.Numbers;
import a1qa.framework.utils.TimeoutConfig;
import a1qa.google.elements.header.Header;
import a1qa.google.pages.SteamDownloadPage;
import a1qa.google.utils.FileSearcher;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.google.utils.SteamConfig.*;
import static org.testng.Assert.assertTrue;

public class SteamDownloadFile extends BaseTest {
	
	private SteamDownloadPage page;
	
	@Given("^I clicked button for install steam$")
	public void clickInstallSteam() throws Throwable {
		new Header().clickSteamInstall();
	}

	@When("^the Steam Download page is opened$")
	public void isSteamDownloadPage() throws Throwable {
		page = new SteamDownloadPage();
	}

	@Then("^I downloaded file for my OC$")
	public void clickDownload() throws Throwable {
		page.startDownloading();
	}

	@Then("^I checked the file$")
	public void checkDownloadingFile() throws Throwable {
		int counter = Numbers.ZERO.getNumber();
		boolean bool = false;
		do {
			if(FileSearcher.isFileAvailable(pathToFile)) {
				bool = true;
			}
			log.info("Cycle waiting for file download");
			++counter;
			BaseTest.sleepTimeout(TimeoutConfig.MIN.getTimeout());
		} while (counter < Numbers.SIX.getNumber() || !bool);
		assertTrue(bool, "Downloading error");
		log.info("File successfully uploaded");
	}
}