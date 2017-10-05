@steam_download
Feature: Steam download

Scenario:  Check download file
Given site http://store.steampowered.com/ was opened
	And Swap language version of the site
		And I clicked button for install steam
When the Steam Download page is opened
Then I downloaded file for my OC
 And I checked the file