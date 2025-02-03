Feature: Shipper Functionality
  This feature is about The Shipper Functionality

  @RegressionTest @Smoke
  Scenario: 01 Create an Event in TD and assign the event to SP
    Given Create a Event-- TD -- Feature - ShipperFunction
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Chassis       | AutoTruck         |
    When Enter Service details -- Feature - ShipperFunction
      | EquipmentType | System | SubSystem | Service              | Defect                  | Location                 | Size1 | Size2|
      | Chassis       | Tire   | Flap      | Flap - Replace w/new | Associated With Repairs | LIC - Left Inside Center | 10-20 | 10-20|
    And Get Event information from -- TD
    And Assign TD event to -- AutoTruck SP -- Payment Method - Cash
    And Get Event information from -- SP
    Then Validate Shipper Function
