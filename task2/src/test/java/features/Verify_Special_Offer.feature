@special_offer
Feature: Verify special offer

Background: 
Given site http://store.steampowered.com/ was opened
	And Swap language version of the site

Scenario: Specials offers in the Actons
When I choose in Games - Action
	And I choose Specials tab
		And I choose sorting the Action games
			And I choose the game with the maximum discount
Then I went to the page with the game
	And checked the game data from the Actions page
	
Scenario: Specials offers in the Casual 
When I choose in Games - Casual
	And I choose Specials tab
		And I choose sorting the Casual games
			And I choose the game with the maximum discount
Then I went to the page with the game
	And checked the game data from the Actions page