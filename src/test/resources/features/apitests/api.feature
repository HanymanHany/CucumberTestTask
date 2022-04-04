Feature: api tests for

Scenario: testGetGuestToken
  When we send a request to get the data of the default user
  Then the response comes with an authorization token

Scenario: testRegisterPlayer
  When we execute a request to create a new player
  Then in the response we get the player's data

Scenario: testLoginCreatedPlayer
  When we execute a request to create a new player and log in under him
  Then the in the response we get an authorization token

Scenario: testCheckDateProfilePlayer
  When we make a request to get data on a specific player
  Then in the response we get correct the player's data

Scenario: testCheckDateProfileNotExistPlayer
  When we execute a request to get data on a non-existent player
  Then we get a 404 error in the response