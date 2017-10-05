@track_prices
Feature: Check the ability to the track prices

Background: 
Given site https://www.google.com/flights/ was opened
	And Swap language version of the site
					
Scenario Outline: Checking the price tracking function for logged user
When I logged in with <login> and <password>
	And I switched Places tab
		And entered the <place>
Then in results viewed correct information <place>
When I switched this result
Then there is this place
When I switched this place
	And information flights 
Then opened flights page
When I clicked track prices
Then track prices function is turned on
	
Scenario Outline: Check the price tracking function for unregistered users
When I logged in with <login> and <password>
	And I switched Places tab
		And entered the <place>
Then in results viewed correct information <place>
When I switched this result
Then there is this place
When I switched this place
	And information flights 
Then opened flights page
When I clicked track prices
Then track prices function is turned on
When I logged out
	And I went one step back
Then flights page was opened
	And track prices function is turned 

Examples: 
	  | login 			              | password     | place           |
    | 'popovich.a1qa@gmail.com' | 'popovichev' | 'Moscow Russia' |