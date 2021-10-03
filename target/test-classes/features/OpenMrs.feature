Feature: Login in Open MRS Portal

@regression @smoke
Scenario: Unsuccessful login
Given user on the Login Page
And user enters "user" with "Admin" 
And user enters "password" with "Admin155"
And user clicks location with "Isolation Ward" 
And user clicks login button
Then error message displayed with wrong password

Scenario: Verification of Login Function  
Given user on the Login Page
And user enters "user" with "Admin" 
And user enters "password" with "Admin123"
And user clicks location with "Isolation Ward" 
And user clicks login button
Then user should see Admin Account

Scenario: Verification of patient registration
Given user on the Login Page
And user enters "user" with "Admin" 
And user enters "password" with "Admin123"
And user clicks location with "Isolation Ward" 
And user clicks login button
Then user should see Admin Account
And user clicks on registration page
And user enters name "firstTest" and "lastTest"
And user enter select gender "Female"
And user enter date of birth
And user enter address with "demo" and "demo add" and "city" and "state" and "con" and "111111"
And user enter number "1111111111"
Then patient should be registered

Scenario: Verify patient record is deleted successfully.
Given user on the Login Page
And user enters "user" with "Admin" 
And user enters "password" with "Admin123"
And user clicks location with "Isolation Ward" 
And user clicks login button
Then user should see Admin Account
Given user search created record with name "firstTest"
And delete created record with reason "xyz"
Then user should not be able to search record with name "firstTest"
And user logout from application


