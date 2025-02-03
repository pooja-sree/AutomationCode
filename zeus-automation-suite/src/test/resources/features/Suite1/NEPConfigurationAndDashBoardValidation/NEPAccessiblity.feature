Feature: Access NEP view
  This feature verifies all combinations of NEP view access

  Background:
  Given Disable NEP access
  | TenantName             |
  | AutoTruck SP |

  @RegressionTest
  Scenario: 01 NEP Access--Mark New Page as Default--Switch Back to Old Event Page-- Create-Edit-Show-Clone
    Given Configure NEP access
      | TenantName             | NEPAccessibility | MarkNewPageAsDefault | SwitchBackToOldEventPage |Create|Edit|Show|Clone|
      | AutoTruck SP           | Yes              |  Yes					 | Yes          |Yes   |Yes |Yes |Yes  |
    When Create a Event-- SP -- Feature - SPEventCreation
      | CustomerName 	| EquipmentType | EquipmentProvider |TruckDispatch |
      | AutoTruck TD    | Chassis       | AutoTruck         | AutoTruck TD |
    And Verify NEP Banner -- NewPage -- Create
    And Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                  | Defect  | Location |
      | Chassis       | Brakes | Airline   | Air Hose - Replace w/new | Missing | Front    |
    And Get Event information from -- SP
    Then Verify Event Status
      | StatusType | TenandType                 | Status      | Page      |
      | Single     | SP         | Submitted   | EventInfo |
#    And Verify NEP Banner -- New Page -- Show
#    And Verify NEP Banner -- New Page -- Edit
#    And Verify NEP Banner -- New Page -- Clone