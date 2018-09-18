Feature: Logging into the Demo Website

Scenario Outline: Verifying that the user can login to the Demo Website

 Given I open the website in a browser
 When I login with credentials using "<record>"
 Then Flight Finder Page is displayed


 Examples:

 | record |
 | record1 |
 | record2 |
 | record3 |