Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I open the browser and navigate to login page
    When I enter username "standard_user" and password "secret_sauce"
    Then I should land on the home page
