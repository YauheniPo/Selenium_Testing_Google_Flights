@check_wallet
Feature: Check user wallet
					
Scenario: Сhange user profile name
Given site http://store.steampowered.com/ was opened
	And Swap language version of the site
		And I logged in
			And I switched to account details
When the account details page is opened
Then I checked the money and currency