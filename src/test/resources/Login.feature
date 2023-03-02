@login
Feature: Login scenarios

	Scenario Outline: Login with invalid username
		Given I'm on the Home page
		When I go to Login page
		And I enter username as "<username>"
		And I enter password as "<password>"
		And I press Login
		Then Login should fail with an error "<err>"
		Examples:
			| username | password | err |
			| invalidUsername | 10203040 | Provided credentials do not match any user in this service. |
			
	Scenario Outline: Login with invalid password
		Given I'm on the Home page
		When I go to Login page
		And I enter username as "<username>"
		And I enter password as "<password>"
		And I press Login
		Then Login should fail with an error "<err>"
		Examples:
			| username | password | err |
			| bob@example.com | invalidPassword | Provided credentials do not match any user in this service. |
			
	Scenario Outline: Login with valid username and password
		Given I'm on the Home page
		When I go to Login page
		And I enter username as "<username>"
		And I enter password as "<password>"
		And I press Login
		Then I should see Products page with title "<title>"
		Examples:
			| username | password | title |
			| bob@example.com | 10203040 | Products |