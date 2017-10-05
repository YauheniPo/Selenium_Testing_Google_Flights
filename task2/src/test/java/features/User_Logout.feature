@logout
Feature: User Logout

Scenario: Logout from user profile page
Given site http://store.steampowered.com/ was opened
	And Swap language version of the site
		And I logged in
When I switched to profile
	And I logout
Then Community Activity page was opened
	And I is not logged in
When I clicked logo
Then Home page was opened
	And  I is not logged in
When I went one step back
Then Community Activity page was opened