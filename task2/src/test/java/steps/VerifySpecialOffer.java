package steps;

import context.ScenarioContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.framework.utils.RegExConfig.*;
import static a1qa.google.utils.SteamConfig.*;
import static a1qa.google.utils.SteamLocators.*;
import static a1qa.framework.utils.ConstantValue.*;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import a1qa.framework.test.BaseTest;
import a1qa.framework.utils.Numbers;
import a1qa.framework.utils.TimeoutConfig;
import a1qa.google.entity.Game;
import a1qa.google.pages.ActionPage;
import a1qa.google.pages.AgeCheckPage;
import a1qa.google.pages.GamePage;
import a1qa.google.pages.HomePage;
import a1qa.google.utils.NavBar;
import a1qa.google.utils.SortingCheckBox;

public class VerifySpecialOffer extends BaseTest {

	private GamePage gamePage;
	private ActionPage actionPage;
	private WebElement element;
	private List<WebElement> tags1 = new ArrayList<WebElement>();
	private List<WebElement> tags2 = new ArrayList<WebElement>();
	private List<String> tagNames1 = new ArrayList<String>();
	private List<String> tagNames2 = new ArrayList<String>();

	private void switchAndCheckCheckbox(By locator) {
		actionPage.clickElement(locator);
		assertNotNull(actionPage.choiceComboBox(LOCATOR_SORT_CHECKING).fetchListElements(LOCATOR_ELEMENT_SORT_CHECKING)
				.findElement(locator), "Incorrect sorting");
	}

	private void fetchGame(String keyEntity, String nameGame, String discount, String price) {
		int counter = Numbers.ZERO.getNumber();
		do {
			try {
				ScenarioContext.getInstance().put(keyEntity, new Game(nameGame, discount, price));
				break;
			} catch (StaleElementReferenceException e) {
				log.info("Cycle game information repeat " + e.getMessage());
				++counter;
			}
			BaseTest.sleepTimeout(TimeoutConfig.MIN.getTimeout());
		} while (counter < Numbers.SIX.getNumber());
	}

	private WebElement getGamesWithMaxDiscount() {
		int counter = Numbers.ZERO.getNumber();
		do {
			try {
				element = actionPage.choiceComboBox(LOCATOR_SET_GAMES).fetchListElements(TAG_A)
						.findMaxValueElement(LOCATOR_GAME_DISCOUNT_PCT);
				break;
			} catch (StaleElementReferenceException e) {
				log.info("Cycle box gemas repeat " + e.getMessage());
				++counter;
			}
			BaseTest.sleepTimeout(TimeoutConfig.MIN.getTimeout());
		} while (counter < Numbers.SIX.getNumber());
		return element;
	}
	
	private List<String> getTagNames(List<WebElement> elements) {
		List<String> tagNames = new ArrayList<String>();
		for (WebElement element : elements) {   
			tagNames.add(getStrToRegEx(element.getText(), REG_EX_GAME_TAG_TEXT));
		}
		return tagNames;
	}
	
	private int equalsTags(List<String> list1, List<String> list2) {
		int n = 0;
		for (String elem1 : list1) {  
			for (String elem2 : list2) {   
				if (elem1.equals(elem2)) {
					++n;
				}
			}
		}
		return n;
	}

	@When("^I choose in Games - Action$")
	public void choiceActionPage() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.pointNavbar(NavBar.GAMES.getLocator());
		element = homePage.choiceElementNavbar(NavBar.BTN_ACTION);
		ScenarioContext.getInstance().put(NAME_BUTTON, element.getText());
		homePage.mouseClick();
	}

	@When("^I choose Specials tab$")
	public void choiceSpecialsTab() throws Throwable {
		actionPage = new ActionPage((String) ScenarioContext.getInstance().getValue(NAME_BUTTON));
		actionPage.clickTab(LOCATOR_SPECIALS);
	}

	@When("^I choose sorting the Action games$")
	public void sortingActionGames() throws Throwable {
		switchAndCheckCheckbox(SortingCheckBox.INDIE.getXpath());
		switchAndCheckCheckbox(SortingCheckBox.STRATEGY.getXpath());
		switchAndCheckCheckbox(SortingCheckBox.SINGLE_PLAYER.getXpath());
	}

	@When("^I choose the game with the maximum discount$")
	public void choiceGameMaximumDiscount() throws Throwable {
		actionPage.setElement(getGamesWithMaxDiscount());
		tags1 = getElementsFromElement(element, LOCATOR_GAME_TAGS);
		fetchGame(GAME_1, actionPage.getText(LOCATOR_GAME_NAME),
				getStrToRegEx(actionPage.getText(LOCATOR_GAME_DISCOUNT_PCT), REG_EX_VALUE_INT),
				getStrToRegEx(actionPage.getText(LOCATOR_GAME_PRICE), REG_EX_VALUE_DOUBLE));
		
		tagNames1 = getTagNames(tags1);
		
		element.click();
	}

	@Then("^I went to the page with the game$")
	public void choicePageWithGame() throws Throwable {
		try {
			new AgeCheckPage().inputValidData();
		} catch (AssertionError e) {
			log.info("Not found checking age " + e.getMessage());
		}
		gamePage = new GamePage();
		fetchGame(GAME_2, gamePage.getName(), getStrToRegEx(gamePage.getDiscount(), REG_EX_VALUE_INT),
				getStrToRegEx(gamePage.getPrice(), REG_EX_VALUE_DOUBLE));
		tags2 = gamePage.switchAllTags().fetchListElements(ELEMENT_TAG_GAME).getListElements();
		
		tagNames2 = getTagNames(tags2);
	}

	@Then("^checked the game data from the Actions page$")
	public void checkingGame() throws Throwable {
		Game g1 = (Game) ScenarioContext.getInstance().getValue(GAME_1);
		Game g2 = (Game) ScenarioContext.getInstance().getValue(GAME_2);
		assertTrue(g1.equals(g2), "Uncorrected game data");
		
		assertEquals(tagNames1.size(), equalsTags(tagNames1, tagNames2), "Incorrect game tags");
		log.info("Corrected game data");
	}

	@When("^I choose sorting the Casual games$")
	public void sortingCasualGames() throws Throwable {
		switchAndCheckCheckbox(SortingCheckBox.ACTION.getXpath());
		switchAndCheckCheckbox(SortingCheckBox.WINDOWS.getXpath());
	}

	@When("^I choose in Games - Casual$")
	public void choiceCasualPage() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.pointNavbar(NavBar.GAMES.getLocator());
		element = homePage.choiceElementNavbar(NavBar.BTN_CASUAL);
		ScenarioContext.getInstance().put(NAME_BUTTON, element.getText());
		homePage.mouseClick();
	}
}