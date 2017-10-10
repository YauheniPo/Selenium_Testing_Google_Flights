@track_prices_for_user
Feature: Check the ability to the track prices
	
Scenario Outline: Check the price tracking function for logged user
Given site https://www.google.com/flights/ was opened
	And Swap language version of the site
When I logged in with <login> and <password>
	And I choose Places tab
		And entered the <place>
Then in results viewed correct information <place>
When I choose this result
Then there is this <place>
When I choose this place
	And information flights 
Then opened flights page
When I clicked track prices
Then track prices function is turned on
When I logged out
	Then was opened page with login form
When I went one step back
Then opened flights page
	And I am not authorized
		And track prices function is turned off

Examples: 
	  | login 			              | password     | place           |
    | 'popovich.a1qa@gmail.com' | 'popovichev' | 'Moscow Russia' |