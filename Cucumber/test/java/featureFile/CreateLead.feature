Feature:  Leaftaps Create Leads flow
Scenario Outline: TC001_Create Lead
Given ChromeBrowser is Opened
And Load Application URL as "http://leaftaps.com/opentaps/"
And Maximize and set timeout for browser
And Enter valid username as <username>
And Enter valid password as <pwd>
And Click on Login button
And Click on CRM link
And Click on Leads Tab
And Click on Create Lead link under Shortcuts
And Enter Company Name as <company>
And Enter Forename as <firstname>
And Enter Surname as <lastname>
When Create Lead button is clicked
Then View Lead should be displayed

Examples:
|username|pwd|company|firstname|lastname|
|'DemosalesManager'|'crmsfa'|'Macreal'|'Jhonny'|'Oliver'|
|'DemoCSR'|'crmsfa'|'Sage Corp'|'Max'|'Twist'|


