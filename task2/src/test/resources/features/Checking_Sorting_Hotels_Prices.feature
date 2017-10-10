@sorting_hotels_prices
Feature: Correct sorting of prices

Scenario Outline: Check the sorting of prices in ASC
Given site https://www.google.com/flights/ was opened
	And Swap language version of the site
When I choose Places tab
	And entered the <place>
Then in results viewed correct information <place>
When I choose this result
Then there is this <place>
When I choose this place
	And information hotels
Then opened hotels page
When I clicked prices tag
Then prices sorted in ASC

Examples: 
	  | place           |
    | 'Moscow Russia' |