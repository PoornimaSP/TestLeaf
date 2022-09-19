Feature: Delete Lead flow

Scenario: TC003_DeleteLead
Given ChromeBrowser is Opened
And Load Application URL as "http://leaftaps.com/opentaps/"
And Maximize and set timeout for browser
And Enter valid username as "DemosalesManager"
And Enter valid password as "crmsfa"
And Click on Login button
And Click on CRM link
And Click on Leads Tab
And Click on Find Leads under Shortcuts
And Click on Phone tab
And Enter Phonenumber
And Click on Find Leads button
And Click on first lead from search result and Note the LeadID
And Click on Delete button
And Click on Find Leads under Shortcuts
And Enter deleted LeadID
When Click on Find Leads button
Then Deleted record should not be displayed


