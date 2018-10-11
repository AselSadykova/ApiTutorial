Feature: Profile GET service

Scenario: Status code test for Profile GET service 

When user hits Profile GET request with "http://localhost:3000/profile"
Then user should get "200" status code 



Scenario: Attribute verification for Profile object

When user hits Profile GET request with "http://localhost:3000/profile"
Then user verifies mandatory attributes for profile



Scenario: Attribute verification for Profile Books title field
When user hits Profile GET request with "http://localhost:3000/profile"
Then user verifies mandatory attribute for profile book title field 



Scenario: Status code test for Profile POST service
When user hits Profile POST request with "http://localhost:3000/profile" "James Bond" "New York" "35"
Then user should get "201" status code



Scenario Outline: Status code test for Profile POST service
When user hits Profile POST request with "http://localhost:3000/profile" "<name>" "<location>" "<age>"
Then user should get "201" status code

Examples:
|name|location|age|
|James Bond|New York| 34|
|John Wick| Madison| 54|
|Adam Smith| Des Plaines| 43|

@test
Scenario Outline: Profile data verification for Profile POST service
When user hits Profile POST request with "http://localhost:3000/profile" "<name>" "<location>" "<age>"
And user hits Profile GET request with "http://localhost:3000/profile"
Then user validates the data in the profile response with the requested data "<name>" "<location>" "<age>"
Examples:
|name|location|age|
|James Bond|New York| 34|
|John Wick| Madison| 54|
|Adam Smith| Des Plaines| 43|
 


