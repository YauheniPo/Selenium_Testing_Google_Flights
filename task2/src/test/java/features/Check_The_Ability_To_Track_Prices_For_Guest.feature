@track_prices_for_guest
Feature: Check the ability to the track prices

Scenario Outline: Check the price tracking function for unregistered user
Given site https://www.google.com/flights/ was opened
	And Swap language version of the site
When I switched Places tab
	And entered the <place>
Then in results viewed correct information <place>
When I switched this result
Then there is this <place>
When I switched this place
	And information flights 
Then opened flights page
When I clicked track prices
Then track prices function is turned off

Examples: 
	  | place           |
    | 'Moscow Russia' |