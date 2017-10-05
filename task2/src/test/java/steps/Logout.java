package steps;

import static a1qa.google.utils.SteamConfig.*;
import static a1qa.google.utils.SteamLocators.*;

import a1qa.google.elements.header.Header;
import a1qa.google.entity.User;
import a1qa.google.pages.CommunityPage;
import a1qa.google.pages.HomePage;
import a1qa.google.pages.UserProfilePage;
import a1qa.google.utils.UserMenuButton;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Logout {
	
	public static User user = createUser();
	
	@When("^I logout$")
	public void userLogout() throws Throwable {
		new UserProfilePage().choiceHeader().choiceAccountMenu().clickMenu().clickButton(UserMenuButton.LOGOUT.getXpath());
	}

	@Then("^Community Activity page was opened$")
	public void checkingCommunityActivityPage() throws Throwable {
		new CommunityPage();
	}
	
	@Then("^I is not logged in$")
	public void checkingLogging() throws Throwable {
		new Header().checkUserLogout(user.getLogin());
	}
	
	@When("^I clicked logo$")
	public void clickLogo() throws Throwable {
		new CommunityPage().clickElement(LOGO_LOCATOR);
	}
	
	@Then("^Home page was opened$")
	public void checkHomePage() throws Throwable {
		new HomePage();
	}

	@When("^I went one step back$")
	public void stepBack() throws Throwable {
		new Header().checkUserLogout(user.getLogin()).clickback(); 
	}
}