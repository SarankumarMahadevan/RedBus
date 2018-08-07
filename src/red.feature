Feature: Red bus login

Scenario: the user books for a bus seat successfully
Given the user enters the Redbus Webpage
When the user enters the source location
And the destination location
And the user enters the onward date and return dates
Then the user searches for the available buses
And the user views the seat to book
And the user prefers for certain seat location
And the user enters the exact pickup location
Then the user proceeds to fill in details page
And the user enters the necessary details such as name,gender,age,email,phone number
Then the user finally proceeds to payment page  
