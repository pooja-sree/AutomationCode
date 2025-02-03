Feature: Equipment360
  This feature verifies all combinations of Equipment360  feature

  @RegressionTest
  Scenario: 01 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- Fleet -- Feature - Duplicate
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Container       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Per Contract | Complete    |
    And Get Event information from -- Fleet
    And Validate Equipment360 activity -- Dashboard
      | EquipmentType | EquipmentNumber | EquipmentProvider | SourceTruck  | Make       | Model | Year | Vin               | Liscence |
      | Container     | QLBC055707      | AutoTruck Fleet   | QLBC055707   | Mistibushi | Truck | 2018 | 12121234345665432 | Test123  |
     
    @RegressionTest @Smoke
     Scenario: 02 Create a TD Event--Chassis-- Single Service line Brakes and Tire
    Given Create a Event-- Fleet -- Feature - Duplicate
      | CustomerName | EquipmentType | EquipmentProvider |
      | AutoTruck TD | Container       | AutoTruck         |
    When Enter Service details -- Create
      | EquipmentType | System | SubSystem | Service                | Defect                 | Location |
      | Container     | OTR Service | OTR Labor   | Service Call - Mechanical | Per Contract | Complete    |
   And Get Event information from -- Fleet
   And Validate Equipment360 activity -- EditPage
      | EquipmentType | EquipmentNumber | EquipmentProvider | Make       | Model | Year | Vin               | Liscence |
      | Container       | QLBC055707      | AutoTruck Fleet   | Mistibushi | Truck | 2018 | 12121234345665432 | Test123  |
    