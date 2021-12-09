Feature: User Registration
    I want to check that the user can register in our e-commerce website

Scenario Outline: User Registration
Given  the usr in home page
When I click on register link
And I entered "<firstname>" , "<lastname>" , "<email>" , "<password>" 
Then the registration page displayed successfully 

Examples: 
  | firstname | lastname | email | password |
  | fatma | saber | fatmaa@test.com | 12345678 |
  | fatma | saber | fatmaaa22@test.com | 12345678 |
  | fatma | saber | fatmaaaa33333@test.com | 12345678 |
  