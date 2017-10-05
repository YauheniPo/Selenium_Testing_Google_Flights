package a1qa.google.pages;

import static org.testng.Assert.*;

import org.openqa.selenium.By;

import a1qa.framework.elements.Label;
import a1qa.framework.elements.TextBox;
import a1qa.framework.pages.BasePage;

public class EditProfilePage extends BasePage {

	private final static By LOCATOR_EDIT_PROFILE_PAGE = By.xpath("//title[contains(text(), 'Edit Profile')]");
	private final By BTN_SAVE_NEW_PROFILE = By.xpath("//button[@type='submit']");
	private final By BTN_CANCEL_NEW_PROFILE = By.xpath("//div[contains(@class, 'action')]/a");
	private final By BTN_RETURN_FROFILE = By.xpath("//div[contains(@class, 'saved_changes')]/a");
	private final By LOCATOR_CHANGES_SAVED = By.xpath("//div[contains(@class, 'saved_changes')]");
	private final By LOCATOR_NAME = By.xpath("//span/a[contains(@class, 'whiteLink')]");
	public static final By FIELD_PROFILE_NAME = By.xpath("//input[contains(@id, 'personaName')]");
	
	public EditProfilePage() {
		super(LOCATOR_EDIT_PROFILE_PAGE);
		log.info("Opened edit profile page");	
	}
	
	public EditProfilePage editProfileName(String newName) {
		log.info("Inputted new name profile: " + newName);
		new TextBox(FIELD_PROFILE_NAME).inputData(newName);
		return this;
	}
	
	public EditProfilePage clearField() {
		log.info("Сlearing field");
		
		new TextBox(FIELD_PROFILE_NAME).clearData();
		return this;
	}
	
	public void submit() {
		log.info("Clicked save new profile name");
		clickElement(BTN_SAVE_NEW_PROFILE);
	}
	
	public void cancel() {
		log.info("Clicked cancel");
		clickElement(BTN_CANCEL_NEW_PROFILE);
	}
	
	public UserProfilePage returnToProfile() {
		log.info("Clicked return to profile");
		clickElement(BTN_RETURN_FROFILE);
		return new UserProfilePage();
	}
	
	public EditProfilePage checkChanges() {
		log.info("Checked for changes");
		assertTrue(isNotNull(LOCATOR_CHANGES_SAVED), "Сhanges not saved");
		return this;
	}
	
	public Label checkName() {
		log.info("Checked for changes");
		return checkElementLabel(LOCATOR_NAME);
	}
}