@edit_profile
Feature: Edit user Profile

Background: 
Given site http://store.steampowered.com/ was opened
	And Swap language version of the site
		And I logged in
			And I switched to profile
				And I switched to profile editing
					And I entered a new profile name
					
Scenario: Сhange user profile name
When I saved the changes
	And I updated page
Then profile has new name
When I press a button - Return to My profile
Then profile page was opened
When I opened the history of names
Then in history is old profile name
	
Scenario: Profile change cancellation
When I an input was cancelled
Then profile page was opened
	And the profile name has not changed
When I opened the history of names
Then in the history no entered name