Feature: Ancillary Location, Service Line Attachment and Draft Event
  This feature verifies Ancillary Location, Service Line Attachments and Draft Evrnt functionality in NEP

#  @RegressionTest @Smoke @Sanity
#  Scenario: 01 Create a TD Event--Power Unit--Single--Brakes--AncillaryLocation
#    Given Create a Event-- TD -- Feature - AncillaryLocation
#      | CustomerName | EquipmentType | EquipmentProvider |
#      | AutoTruck TD  | Power Unit    | AutoTruck         |
#    When Enter Service details -- AncillaryLocation
#      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
#      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
#    And Get Event information from -- TD
#    Then Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventLog   | TD         | Open | EventInfo |
#    Then Validate Ancillary Location Info -- TD

  @RegressionTest
  Scenario: 02 Create a CC Event--Chassis--with Attachment
    Given Create a Event-- CC -- Feature - CCEventCreation
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- with Attachments
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- CC
    Then Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | CC         | Submitted | EventInfo |
    Then Validate OtherAttachment Info -- CC

  @RegressionTest
  Scenario: 03 Create a Fleet Event--Container--with Pre Attachment
    Given Create a Event-- Fleet -- Feature - Attachments
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck Fleet   | Container  | AutoTruck      |
    When Enter Service details -- with Pre Attachments
    	| EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Associated with Repairs | Complete    |
    And Get Event information from -- Fleet
    Then Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | eventLog   | Fleet         | Open | EventInfo |
    Then Validate Pre-repairAttachment Info -- Fleet

#  @RegressionTest
#  Scenario: 04 Create a SP Event--Chassis--with Post Attachment
#    Given Create a Event-- SP -- Feature - CCEventCreation
#      | CustomerName    | EquipmentType | EquipmentProvider |
#      | AutoTruck TD    | Power Unit    | AutoTruck         |
#   	When Enter Service details -- with Post Attachments
#      | EquipmentType | System | Assembly        | Component             | Position     | WorkAccomplished | Reason      |
#      | Power Unit    | Brakes | Electric Brakes | Electric Brakes (EBS) | Front Center | Adjust           | Abandonment |
#    And Get Event information from -- SP
#    Then Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventLog   | SP | Submitted | EventInfo |
#    Then Validate Post-repairAttachment Info -- SP

#  @RegressionTest
#  Scenario: 05 Create a TD Draft Event--Chassis--Single--Brakes
#    Given Create a DraftEvent-- TD -- Feature - Draft
#      | EquipmentType | EquipmentProvider |
#      | Chassis       | AutoTruck         |
#    Then Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventStatus| TD         | Draft     | Dashboard |
#    And Create the DraftEvent

#  @RegressionTest @Smoke @Sanity
#  Scenario: 06 Create a CC Draft Event--Chassis--Single--Brakes
#    Given Create a DraftEvent-- CC -- Feature - DraftEvent
#      | EquipmentType | EquipmentProvider |
#      | Container     | AutoTruck         |
#    Then Verify Event Status
#      | StatusType | TenandType | Status    | Page      |
#      | eventStatus| CC         | Draft     | Dashboard |
#    And Delete the DraftEvent