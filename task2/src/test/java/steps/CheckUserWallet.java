package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static a1qa.framework.utils.RegExConfig.*;
import static a1qa.google.utils.SteamConfig.*;

import org.testng.asserts.SoftAssert;

import a1qa.framework.utils.RegExConfig;
import a1qa.google.elements.header.Header;
import a1qa.google.pages.AccountDetailsPage;
import a1qa.google.utils.UserMenuButton;

public class CheckUserWallet {
	
	private AccountDetailsPage accountDetailsPage;

	@Given("^I switched to account details$")
	public void switchToAccountDetails() throws Throwable {
		new Header().choiceAccountMenu().clickMenu().clickButton(UserMenuButton.ACCOUNT_DETAILS.getXpath());
	}

	@When("^the account details page is opened$")
	public void checkAccountDetailsPage() throws Throwable {
		accountDetailsPage = new AccountDetailsPage();
	}

	@Then("^I checked the money and currency$")
	public void checkUserWallet() throws Throwable {
		String strCash = accountDetailsPage.getWalletCash();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(strCash.contains(CURRENCY_SIGN), "Currency sign in wallet is wrong");
		softAssert.assertEquals(RegExConfig.getStrToRegEx(strCash, REG_EX_VALUE_DOUBLE), VALUE_WALLET,
				"Balance is not correct");
		softAssert.assertEquals(RegExConfig.getStrToRegEx(strCash, REG_EX_UPPER_TEXT), TITLE_CURRENCY,
				"Currency is not correct");
		softAssert.assertAll();
	}
}