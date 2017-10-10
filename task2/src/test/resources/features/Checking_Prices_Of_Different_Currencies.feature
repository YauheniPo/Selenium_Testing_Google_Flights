@checking_currencies_and_prices
Feature: Check correct prices of different currencies

Scenario Outline: Check prices of different currencies
Given site https://www.google.com/flights/ was opened
	And Swap language version of the site
When I choose Places tab
	And entered the <place>
Then in results viewed correct information <place>
When I choose this result
Then there is this <place>
When I switched currency <currency1>
Then there was a new price
When I switched currency <currency2>
Then there was a new price
	And the price difference corresponds to a <coefficient> within <pct>

Examples:
 		| place           | currency1 | currency2 | coefficient | pct |
    | 'Moscow Russia' |	  'USD' 	|   'EUR'   |    '1.17'   | 10  |