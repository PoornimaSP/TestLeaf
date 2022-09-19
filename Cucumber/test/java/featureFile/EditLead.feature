Feature: Leaf Taps Edit Lead Flow

Scenario Outline: TC002_Edit Lead
Given ChromeBrowser is Opened
And Load Application URL as "http://leaftaps.com/opentaps/"
And Maximize and set timeout for browser
And Enter valid username as <username>
And Enter valid password as <pwd>
And Click on Login button
And Click on CRM link
And Click on Leads Tab
And Click on Find Leads under Shortcuts
And Click on Phone tab
And Enter Phonenumber
And Click on Find Leads button
And Click on first lead from search result
And Click on Edit button
And Update Company Name value "ABC corp"
And Click on Update button

Examples:
|username|pwd|
|'DemosalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|
