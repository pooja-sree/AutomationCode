Feature: Event TemplatesNEP
  This feature verifies all combinations of event creation with Priority from Event Templates functionality

    @RegressionTest @Smoke @Sanity
    Scenario: 01 Create an TD Template--EventTemplate
      Given Create an Template-- TD -- EventTemplates - TD
      | EquipmentType | EquipmentProvider | ReportedLocation | Priority  | TemplateName    |
      |   Chassis     | AutoTruck         | San Francisco    | Emergency | Td Test Template|
      When Enter Service details -- TD
      | EquipmentType | System | SubSystem | Service                  | Defect   | Location | CreateTemplate |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Worn Out | Front    |   Yes          |
      Then Verify Event Template-- TD
      | EquipmentType | Chassis no   | Location type | ReportedLocation       | Priority  |
      | Chassis       | Yes          | Yard Check    | San Francisco, CA, USA | Emergency |
      And Update an Template using EventTemplates-- TD
      | EquipmentType |   Reported by user | Priority |
      | Container     |   driver           | elevated |
       
 @RegressionTest
   Scenario: 02 Create a SP Template--EventTemplates-- SP
      Given Create an Template-- SP -- EventTemplates - Walkin
      | CustomerName | EquipmentType  | Crosswalk   |  Priority   | TemplateName |
      | AutoTruck SP | Power Unit     | SPCrosswalk |  Emergency  |SP Test Template|
      Then Verify Event Template-- SP
      | EquipmentType | Crosswalk   |
      | Power Unit    | SPCrosswalk |
      And Update an Template using EventTemplates-- SP
      | EquipmentType | Customfields |
      | Snow Scraper  | test         |

    @RegressionTest
    Scenario: 03 Create a CC Event--EventTemplates--Snow Scraper
      Given Create an Template-- CC -- EventTemplates - Crosswalk
      | EquipmentType  | EquipmentProvider | Crosswalk    | Shipper  |TemplateName|
      |  Snow Scraper  | AutoTruck         | SPCrosswalk  | Autoship |CC Test Template|
      Then Verify Event Template-- CC
      | EquipmentType |Crosswalk  | Shipper           |
      | Snow Scraper  |SPCrosswalk| Autotruck Shipper |
      And Update an Template using EventTemplates-- CC
      | EquipmentType | BreakdownLocation  |
      | Trailer       | Test               |

  @RegressionTest @Smoke
  Scenario: 04 Create a Fleet Event--EventTemplate-- Chassis
    Given Create an Event using EventTemplates-- Fleet
      | EquipmentType | EquipmentProvider |
      | Chassis       | AutoTruck         |
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType    | Status | Page      |
      | Single     | FLEET         | Open   | Dashboard |
      | Single     | FLEET         | Open   | EventInfo |
    And AssignDuplicate1 Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType    | Status    | Page      |
      | Single     | FLEET         | Submitted | Dashboard |
      | Single     | FLEET         | Submitted | EventInfo |
#    Then Validate Event Priority Info -- TD

  @RegressionTest
  Scenario: 05 Create a Fleet Event--EventTemplates-- PowerUnit
    Given Create an Event using EventTemplates-- Fleet
      | EquipmentType  | EquipmentProvider |
      | Power Unit     | AutoTruck         |
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType    | Status | Page      |
      | Single     | FLEET         | Open   | Dashboard |
      | Single     | FLEET         | Open   | EventInfo |
    And AssignDuplicate Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | FLEET         | Submitted | Dashboard |
      | Single     | FLEET         | Submitted | EventInfo |
 #   Then Validate Event Priority Info -- SP

  @RegressionTest
  Scenario: 06 Create a Fleet Event--EventTemplates--Container--Single--Brakes
    Given Create an Event using EventTemplates-- Fleet
      | EquipmentType | EquipmentProvider |
      | Container     | AutoTruck         |
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | FLEET         | Open   | Dashboard |
      | Single     | FLEET         | Open   | EventInfo |
    And AssignDuplicate Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | FLEET         | Submitted | Dashboard |
      | Single     | FLEET         | Submitted | EventInfo |
    #   Then Validate Event Priority Info -- SP

  @RegressionTest
  Scenario: 07 Create a Fleet Event--EventTemplates--Trailer
    Given Create an Event using EventTemplates-- Fleet
      | EquipmentType | EquipmentProvider |
      | Trailer       | AutoTruck         |
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status | Page      |
      | Single     | FLEET         | Open   | Dashboard |
      | Single     | FLEET         | Open   | EventInfo |
    And AssignDuplicate Fleet event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- Fleet
    And Verify Event Status
      | StatusType | TenandType | Status    | Page      |
      | Single     | FLEET         | Submitted | Dashboard |
      | Single     | FLEET         | Submitted | EventInfo |
#    Then Validate Event Priority Info -- SP