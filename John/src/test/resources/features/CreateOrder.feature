Feature: 
As a user 
I want to create an order
so that i can successfully send my information to the related persons

#@CreateOrder
#Scenario: 
#Given user is on crareate order page
#When user enter vaild data 
#And user submit all data 
#Then order should successfully created with message

@CreateOrder
Scenario:
Given I am on create order page
When  I provide all the required valid data
And   I submit the order
Then  order should be successfully created with a message
And   order should appear in Dashboard


