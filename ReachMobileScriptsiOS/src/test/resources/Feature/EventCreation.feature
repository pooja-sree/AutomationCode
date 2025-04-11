Feature: Service Event Creation

  Scenario: 1.Admin creates an event and assigns technician --Technician(Accepts,Departs,Arrive and Repair) -- Admin completes it
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Create an event "EventCreation"
      |EquipmentType|
      |PoWerUnit    |
    Then Enter Service Details "Create"
      |EquipmentType|System|Assembly|Component|Position|WorkAccomplished|ReasonForRepair|Comments                          |
      |PoWerUnit    |050   |000     |000      |  00    |  017           |  062          |PoWerUnit event through automation|
    And Search Event
    And Event Details Action "Accept"
    And Assign Technician "Technician1"
    And Search EventID
    And GoBack1
    Then Logout
    Given Login as "SC-Technician"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autotechnician@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Tech Accept with ETA" by "SC-Technician"
    Then Event Action "Tech Departed" by "SC-Technician"
    Then Event Action "Tech Arrive with ETC" by "SC-Technician"
    Then Event Action "Tech Repaired" by "SC-Technician"
    And GoBack1
    Then Logout
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Complete" by "SC-Admin"
    And GoBack1
    Then Logout



  Scenario: 2. Admin Creates an event and Rejects
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Create an event "EventCreation"
      |EquipmentType|
      |PoWerUnit    |
    Then Enter Service Details "Create"
      |EquipmentType|System|Assembly|Component|Position|WorkAccomplished|ReasonForRepair|Comments                          |
      |PoWerUnit    |050   |000     |000      |  00    |  017           |  062          |PoWerUnit event through automation|
    And Search Event
    And Event Details Action "Accept"
    And Event Action "Reject" by "SC-Admin"
    And GoBack2
    Then Logout



  Scenario: 3. Admin creates an event,Accepts and assigns technician --Technician(Accepts,Not Departs and Departs,Arrive and Repair) -- Admin completes it

    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Create an event "EventCreation"
      |EquipmentType|
      |PoWerUnit    |
    Then Enter Service Details "Create"
      |EquipmentType|System|Assembly|Component|Position|WorkAccomplished|ReasonForRepair|Comments                          |
      |PoWerUnit    |050   |000     |000      |  00    |  017           |  062          |PoWerUnit event through automation|
    And Search Event
    And Event Action "Accept" by "SC-Admin"
    And Event Details Action "Reject"
    And Assign Technician "Technician1"
    And Search EventID
    And GoBack1
    Then Logout
    Given Login as "SC-Technician"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autotechnician@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Tech Accept" by "SC-Technician"
    Then Event Action "Tech Not Departed" by "SC-Technician"
    Then Event Action "Tech Departed" by "SC-Technician"
    Then Event Action "Tech Arrive with ETC" by "SC-Technician"
    Then Event Action "Tech Repaired" by "SC-Technician"
    And Search EventID
    And GoBack1
    Then Logout
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Complete" by "SC-Admin"
    And Search EventID
    And GoBack1
    Then Logout


  Scenario: 4. Technician Declines the Event and assigns another technician2
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Create an event "EventCreation"
      |EquipmentType|
      |Trailer      |
    Then Enter Service Details "Create"
      |EquipmentType|System|Assembly|Component|Position|WorkAccomplished|ReasonForRepair|Comments                          |
      |PoWerUnit    |050   |000     |000      |  00    |  017           |  062          |PoWerUnit event through automation|
    And Search Event
    And Event Action "Accept" by "SC-Admin"
    And Event Details Action "Reject"
    And Assign Technician "Technician1"
    And Search EventID
    And GoBack1
    Then Logout
    Given Login as "SC-Technician"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autotechnician@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Tech Decline" by "SC-Technician"
    Then Assign Technician "Technician2"
    And Search EventID
    And GoBack1
    Then Logout


  Scenario: 5. Admin creates an event, Assigns Tech,Departs, Marks not driving, Arrived without ETC , Repairs
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Create an event "EventCreation"
      |EquipmentType|
      |PoWerUnit    |
    Then Enter Service Details "Create"
      |EquipmentType|System|Assembly|Component|Position|WorkAccomplished|ReasonForRepair|Comments                          |
      |PoWerUnit    |050   |000     |000      |  00    |  017           |  062          |PoWerUnit event through automation|
    And Search Event
    And Event Details Action "Accept"
    And Assign Technician "Technician1"
    And Search EventID
    And GoBack1
    Then Logout
    Given Login as "SC-Technician"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autotechnician@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Tech Accept with ETA" by "SC-Technician"
    Then Event Action "Tech Departed" by "SC-Technician"
    Then Event Action "Tech Not Driving" by "SC-Technician"
    Then Event Action "Tech Arrived" by "SC-Technician"
    Then Event Action "Tech Repaired" by "SC-Technician"
    And GoBack1
    Then Logout
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    And Search Event
    Then Event Action "Complete" by "SC-Admin"
    And GoBack1
    And Logout

  @testing
  Scenario: 6. Create events with Attachments
    Given Login as "SC-Admin"
      |Email                                        |Password  |
      |poojasree.kaliyaperumal+autoadmin@reach24.net|Welcome123|
    Then Create an event "EventCreation"
      |EquipmentType|
      |Chassis    |
    Then Enter Service Details "Attachments"
      |EquipmentType|ChassisSystem|SubSystem|Service                    |    Defect              |Location|Comments                          |Category            |
      |Chassis    |Brakes       |ABS      |ABSECUCable - ReplaceW/New |Associated With Repairs |Under   |PowerUnit event through automation|Multiple Attachments|










