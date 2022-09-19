Feature:  Leaftaps Merge Leads flow
Scenario: TC004_Merge Lead
Given ChromeBrowser is Opened
And Load Application URL as "http://leaftaps.com/opentaps/"
And Maximize and set timeout for browser
And Enter valid username as "DemosalesManager"
And Enter valid password as "crmsfa"
And Click on Login button
And Click on CRM link
And Click on Leads Tab
And Click on MergeLeads under Shortcuts
And Click on Img across From Lead
And Enter FirstName as "Hari"
And Click on Find Leads button in the Find Leads window
And Note down first lead ID from search result in the Find Leads window and click
And Click on Img across To Lead
And Search for ToLead to be merged whose FirstName as "Babu"
And Click on Merge button
And Click OK in the Alert
And Click on Find Leads under Shortcuts
And Enter Merged from LeadID
When Click on Find Leads button
Then Merged record should not be displayed


 

