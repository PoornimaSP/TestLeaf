Feature: Leaf Taps Duplicate Lead Flow

Scenario Outline: TC005_Duplicate Lead
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
And Click on Duplicate button
When Click on CreateLead button in Duplicate Lead Page
Then View Lead should be displayed

Examples:
|username|pwd|
|'DemosalesManager'|'crmsfa'|
|'DemoCSR'|'crmsfa'|
