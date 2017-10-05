package steps;

import static a1qa.framework.utils.ConstantValue.*;
import static a1qa.google.pages.EditProfilePage.*;
import static a1qa.google.utils.SteamConfig.*;
import static org.testng.Assert.*;

import a1qa.framework.elements.Label;
import a1qa.framework.utils.Numbers;
import a1qa.google.entity.User;
import a1qa.google.pages.EditProfilePage;
import a1qa.google.pages.HomePage;
import a1qa.google.pages.UserProfilePage;
import a1qa.google.utils.SteamConfig;
import a1qa.google.utils.UserMenuButton;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditUserProfile {
	
	public static User user = createUser();
	private String newProfileName;

	@When("^I switched to profile$")
	public void openUserProfile() throws Throwable {
		new HomePage().choiceHeader().choiceAccountMenu().clickMenu().clickButton(UserMenuButton.VIEW_PROVILE.getXpath());
	}

	@When("^I switched to profile editing$")
	public void openEditProfilePage() throws Throwable {
		new UserProfilePage().choiceEditProfile();
	}

	@When("^I entered a new profile name$")
	public void enterNewProfileName() throws Throwable {
		newProfileName = new SteamConfig().NEW_PROFILE_NAME;
		user.setProfileName(new Label(FIELD_PROFILE_NAME).getAttribute(FIELD_PROFILE_NAME, INPUT_ATRIBUTE_VALUE));
		
		new EditProfilePage().clearField().editProfileName(newProfileName);
	}

	@When("^I saved the changes$")
	public void saveChange() throws Throwable {
		user.setNewProfileName(newProfileName);
		
		EditProfilePage editProfilePage = new EditProfilePage();
		editProfilePage.submit();
		editProfilePage.checkChanges();
	}
	
	@Then("^I updated page$")
	public void updatePage() throws Throwable {
		new EditProfilePage().refreshPage();
	}

	@Then("^profile has new name$")
	public void checkProfileNewName() throws Throwable {
		new EditProfilePage().checkName().checkLabel(user.getNewProfileName());
	}
	
	@Then("^I press a button - Return to My profile$")
	public void pressBtnReturnMyProfile() throws Throwable {
		new EditProfilePage().returnToProfile();
	}
	
	@Then("^profile page was opened$")
	public void isProfilePage() throws Throwable {
		new UserProfilePage();
	}

	@Then("I opened the history of names$")
	public void openHistoryProfileName() throws Throwable {
		new UserProfilePage().clickNamesHistory();
	}	
	
	@Then("^in history is old profile name$")
	public void findOldProfileName() throws Throwable {
		assertTrue(new UserProfilePage().isName(user.getProfileName(), Numbers.ONE.getNumber()), "Not found name");
	}

	@When("^I an input was cancelled$")
	public void i_an_input_was_cancelled() throws Throwable {
		user.setProfileName(user.getNewProfileName());
		
		new EditProfilePage().cancel();
	}

	@Then("^the profile name has not changed$")
	public void checkProfileName() throws Throwable {
		new UserProfilePage().checkName().checkLabel(user.getProfileName());
		
		user.setNewProfileName(newProfileName);
	}	

	@Then("^in the history no entered name$")
	public void notFindNewProfileName() throws Throwable {
		assertFalse(new UserProfilePage().isName(user.getNewProfileName(), Numbers.ZERO.getNumber()), "Found new profile name");
	}
}