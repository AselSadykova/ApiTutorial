Feature: GitHub username repositories


@github
Scenario: UI vs API verification for user repositories 
Given user goes to gitHub account for "http://github.com/eniiazov"
And user hits github repos service with "http://api.github.com/users/eniiazov/repos"
Then user validates repositories data with UI and API

@github
Scenario Outline: UI and API verification for user repositories
Given user goes to gitHub account for "<uiURI>"
And user hits github repos service with "<apiURI>"
Then user validates repositories data with UI and API

Examples:
|uiURI | apiURI|
|http://github.com/eniiazov|http://api.github.com/users/eniiazov/repos|
|http://github.com/james|http://api.github.com/users/james/repos|
|http://github.com/AslSadykova|http://api.github.com/users/AslSadykova/repos|
|http://github.com/hasanistan|http://api.github.com/users/hasanistan/repos|