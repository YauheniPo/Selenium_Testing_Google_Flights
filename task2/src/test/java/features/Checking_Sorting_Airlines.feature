@sorting_airlines
Feature: Check sorting airlines to one airline

Scenario Outline: Check correction sorting airlines
Given site https://www.google.com/flights/ was opened
	And Swap language version of the site
When I choose Places tab
	And entered the <place>
Then in results viewed correct information <place>
When I choose this result
Then there is this <place>
When I choose this place
	And information flights 
Then opened flights page
When I clicked sorting airlines
	And choose Belavia
Then flights only Belavia

Examples: 
	  | place           |
    | 'Moscow Russia' |